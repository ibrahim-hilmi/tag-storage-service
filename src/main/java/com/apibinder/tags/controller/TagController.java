package com.apibinder.tags.controller;

import com.apibinder.tags.dto.ValuePercentDto;
import com.apibinder.tags.dto.TagDto;
import com.apibinder.tags.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @PostMapping("multi")
    public ResponseEntity<TagDto> createMultiTag(@RequestBody List<TagDto> tagDto) {
        tagService.persist(tagDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("count/{uid}/{key}/{limit}")
    public ResponseEntity<Map<String, Integer>> getTagCounts(@PathVariable("uid") String uid, @PathVariable("key") String key, @PathVariable("limit") int limit){
        return new ResponseEntity<>(tagService.findTagCounts(uid, key, limit), HttpStatus.OK);
    }

    @GetMapping("showed/{uid}/{key}/{limit}")
    public ResponseEntity<Map<String, Integer>> getShowedTagCounts(@PathVariable("uid") String uid, @PathVariable("key") String key, @PathVariable("limit") int limit){
        return new ResponseEntity<>(tagService.findShowedTagCounts(uid, key, limit), HttpStatus.OK);
    }

    @GetMapping("percent/{uid}/{key}/{limit}")
    public ResponseEntity<Map<String, Integer>> getTagPercent(@PathVariable("uid") String uid, @PathVariable("key") String key, @PathVariable("limit") int limit){
        return new ResponseEntity<>(tagService.findTagPercents(uid, key, limit), HttpStatus.OK);
    }
}
