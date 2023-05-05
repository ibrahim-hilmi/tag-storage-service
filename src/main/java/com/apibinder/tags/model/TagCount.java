package com.apibinder.tags.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "tag_count")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class TagCount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "`key`")
    private String key;
    private String value;
    private String uid;

    @Column(name = "date")
    private Date date;
    private Integer count;
}
