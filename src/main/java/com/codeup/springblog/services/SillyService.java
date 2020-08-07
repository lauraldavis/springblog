package com.codeup.springblog.services;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service("SillyService")
public class SillyService {

    private PostRepository postsDao;
    private UserRepository usersDao;

    public SillyService(PostRepository postsDao, UserRepository usersDao) {
        this.postsDao = postsDao;
        this.usersDao = usersDao;
    }

    public int totalPostCharacters() {
        Iterable<Post> posts = postsDao.findAll();
        Iterable<User> users = usersDao.findAll();

        int total = 0;

        for (Post post : posts) {
            total += post.getBody().length();
        }

        for (User user : users) {
            total += user.getUsername().length();
        }
        return total;
    }

}
