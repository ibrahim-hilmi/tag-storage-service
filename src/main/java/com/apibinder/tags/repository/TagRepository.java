package com.apibinder.tags.repository;

import com.apibinder.tags.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

    @Query(value = "SELECT tag_value, COUNT(tag_value) value_count \n" +
            "FROM tags \n" +
            "WHERE uid = :uid AND tag_key = :key \n" +
            "GROUP BY tag_value", nativeQuery = true)
    Object[] findTagCounts(@Param("uid") String uid, @Param("key") String key);
}
