package com.apibinder.tags.controller;

import com.apibinder.tags.dto.TagDto;
import com.apibinder.tags.service.TagService.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tag")
public class TagController {

    private final TagService tagService;

    @PostMapping
    public ResponseEntity<TagDto> createTag(@RequestBody TagDto tagDto) {
        return new ResponseEntity<>(tagService.persist(tagDto), HttpStatus.CREATED);
    }

}
