package com.apibinder.tags.service;

import com.apibinder.tags.converter.TagConverter;
import com.apibinder.tags.dto.TagDto;
import com.apibinder.tags.mapper.TagMapper;
import com.apibinder.tags.model.Tag;
import com.apibinder.tags.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class TagService {

    private final TagMapper tagMapper;
    private final TagRepository tagRepository;

    public TagDto persist(TagDto tagDto) {
        Tag tag = persist(tagMapper.map(tagDto));
        return tagMapper.map(tag);
    }

    private Tag persist(Tag tag) {
        if(tag.getId() == null) {
            tag.setCreatedDateUx(System.currentTimeMillis()/1000);
        }
        return tagRepository.save(tag);
    }

    public Map<String, Integer> findTagCounts(String uid, String key) {
        return TagConverter.convertTagCounts(tagRepository.findTagCounts(uid, key));
    }

    public Map<String, Integer> findTagPercents(String uid, String key) {
        Map<String, Integer> percents = new HashMap<>();
        Map<String, Integer> counts = findTagCounts(uid, key);
        int sum = counts.values().stream().mapToInt(i -> i).sum();
        counts.entrySet()
                .forEach(
                        entry -> percents.put(entry.getKey(), entry.getValue() * 100 / sum));
        return percents;
    }
}
