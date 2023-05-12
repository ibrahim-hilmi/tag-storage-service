package com.apibinder.tags.controller;

import com.apibinder.tags.dto.ValuePercentDto;
import com.apibinder.tags.dto.TagDto;
import com.apibinder.tags.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tag")
public class TagController {

    private final TagService tagService;

    @PostMapping
    public ResponseEntity<TagDto> createTag(@RequestBody TagDto tagDto) {
        return new ResponseEntity<>(tagService.persist(tagDto), HttpStatus.CREATED);
    }

    @GetMapping("count/{uid}/{key}")
    public ResponseEntity<Map<String, Integer>> getTagCounts(@PathVariable("uid") String uid, @PathVariable("key") String key){
        return new ResponseEntity<>(tagService.findTagCounts(uid, key), HttpStatus.OK);
    }

    @GetMapping("percent/{uid}/{key}")
    public ResponseEntity<Map<String, Integer>> getTagPercent(@PathVariable("uid") String uid, @PathVariable("key") String key){
        return new ResponseEntity<>(tagService.findTagPercents(uid, key), HttpStatus.OK);
    }
}
