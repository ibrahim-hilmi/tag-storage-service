package com.apibinder.tags.repository;

import com.apibinder.tags.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
