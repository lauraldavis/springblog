package com.codeup.springblog.services;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostSearchKeyword {
    private PostRepository postsDao;

    public PostSearchKeyword(PostRepository postsDao) {
        this.postsDao = postsDao;
    }

//    public List<Post> findByKeyword(String keyword) {
//        if (keyword != null) {
//            return postsDao.findByKeyword(keyword);
//        } else {
//            return postsDao.findAll();
//        }
//    }
}
