package com.apibinder.tags.repository;

import com.apibinder.tags.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
    @Query(value = "SELECT tag_value, COUNT(tag_value) value_count\n" +
            "FROM \n" +
            "(SELECT *\n" +
            "FROM tags\n" +
            "WHERE uid = :uid AND tag_key = :key\n" +
            "ORDER BY id DESC\n" +
            "LIMIT :limit) t\n" +
            "GROUP BY tag_value" , nativeQuery = true)
    Object[] findTagCounts(@Param("uid") String uid, @Param("key") String key, @Param("limit") int limit);

    @Query(value = "SELECT tag_value, COUNT(*) as count\n" +
            "FROM _sweeter.image_tag\n" +
            "WHERE tag_key = :key AND image_id IN (\n" +
            "    SELECT image_id\n" +
            "    FROM (\n" +
            "        SELECT image_id\n" +
            "        FROM _sweeter.image_show_log\n" +
            "        WHERE user_id = :uid\n" +
            "        ORDER BY id DESC\n" +
            "        LIMIT :limit\n" +
            "    ) as subq\n" +
            ")\n" +
            "GROUP BY tag_value" , nativeQuery = true)
    Object[] findShowedTagCounts(@Param("uid") String uid, @Param("key") String key, @Param("limit") int limit);
}
