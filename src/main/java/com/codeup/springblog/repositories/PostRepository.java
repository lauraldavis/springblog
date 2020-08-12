package com.codeup.springblog.repositories;

import com.codeup.springblog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository <Post, Long> {

    List<Post> findAllByOrderByIdDesc();

//    @Query(value="SELECT p FROM posts p WHERE CONCAT(p.title, ' ', p.body) LIKE %:keyword%", nativeQuery=true)
//    List<Post> findByKeyword(@Param("keyword"), String keyword);
}
