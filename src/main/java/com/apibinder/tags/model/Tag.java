package com.apibinder.tags.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "tags")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tag_key")
    private String tag_key;
    @Column(name = "tag_value")
    private String tag_value;
    private String uid;

    @Column(name = "created_date_ux")
    private Long createdDateUx;

}
