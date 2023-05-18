package com.apibinder.tags.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TagDto {
    private Long id;
    private String tag_key;
    private String tag_value;
    private String uid;
    private Long createdDateUx;
}
