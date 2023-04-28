package com.apibinder.tags.service.TagService;

import com.apibinder.tags.dto.TagDto;
import com.apibinder.tags.mapper.TagMapper;
import com.apibinder.tags.model.Tag;
import com.apibinder.tags.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
