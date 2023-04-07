package com.apibinder.tags.mapper;

import com.apibinder.tags.dto.TagDto;
import com.apibinder.tags.model.Tag;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TagMapper {
    Tag map(TagDto tagDto);
    TagDto map(Tag tag);
}
