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
    private String key;
    private String value;
    private String uid;
    private Long createdDateUx;
}
