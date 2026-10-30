package com.kryptic.bloggingplatform.repository;

import com.kryptic.bloggingplatform.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {
}
