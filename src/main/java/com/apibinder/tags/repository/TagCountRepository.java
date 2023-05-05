package com.apibinder.tags.repository;

import com.apibinder.tags.model.TagCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagCountRepository extends JpaRepository<TagCount, Long> {

    @Query("SELECT t FROM TagCount t WHERE t.uid = :uid AND t.key = :key")
    List<TagCount> findCountByUidAndKey(@Param("uid") String uid, @Param("key") String key);

    // TODO: 5.05.2023
//    @Query(value = "SELECT new com.apibinder.tags.dto.UserTagCountDto(sum(t.count), t.value) FROM TagCount t WHERE t.uid = :uid AND t.key = :key GROUP BY t.value")
//    List<UserTagCountDto> findTotalCountByUidAndKey(@Param("uid") String uid, @Param("key") String key);

}
