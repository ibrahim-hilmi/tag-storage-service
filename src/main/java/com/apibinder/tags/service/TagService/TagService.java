package com.apibinder.tags.service.TagService;

import com.apibinder.tags.dto.TagDto;
import com.apibinder.tags.mapper.TagMapper;
import com.apibinder.tags.model.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TagService {

    private final TagMapper tagMapper;

    public TagDto persist(TagDto tagDto) {
        Tag tag = persist(tagMapper.map(tagDto));
        return tagMapper.map(tag);
    }

    private Tag persist(Tag tag) {
        // TODO: 7.04.2023
        return null;
    }
}
