package com.service;

import com.entity.Post;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PostService {

    List<Post> getPostsByUserId(int userId, int pageIndex);

    List<Post> getArticlePosts(int pageIndex);

    List<Post> getChatPosts(int pageIndex);

    List<Post> getImagePosts(int pageIndex);

    List<Post> getVideoPosts(int pageIndex);

    List<Post> getAllPosts(int pageIndex);

    List<Post> getPostsByPostState(int postState, int pageIndex);

    List<Post> getAllPostsWithoutPage();

    Post getPostBypostId(int postId);

    int updatePost(int postId, String postTitle, String postContent);

    int updateChatPost(int postId, String postTitle, String postChat);

    int updatePostState(int postId, int postState);

    int deletePost(int postId);

    int getPostsCountByPostType(int postType);

    int addArticlePost(String postTitle, int postUserId, String postContent);

    int addChatPost(String postTitle, int postUserId, String postChat);

    int addImagePosts(String postTitle, int postUserId, String postContent, String postImage);

    int addVideoPosts(String postTitle, int postUserId, String postContent, String postVideo);

    int getPostsCountByPostState(int postState);

    List<Post> searchPost(String postTitle, int pageIndex);

    int searchPostCount(String postTitle);

    int postHitsUp(int postId);

}
