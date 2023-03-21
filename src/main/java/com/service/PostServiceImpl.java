package com.service;

import com.dao.PostMapper;
import com.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PostServiceImpl implements PostService {

    @Autowired
    private PostMapper postMapper;

    @Override
    public List<Post> getPostsByUserId(int userId, int pageIndex) {
        return postMapper.getPostsByUserId(userId,pageIndex);
    }

    @Override
    public List<Post> getArticlePosts(int pageIndex) {
        return postMapper.getArticlePosts(pageIndex);
    }

    @Override
    public List<Post> getChatPosts(int pageIndex) {
        return postMapper.getChatPosts(pageIndex);
    }

    @Override
    public List<Post> getImagePosts(int pageIndex) {
        return postMapper.getImagePosts(pageIndex);
    }

    @Override
    public List<Post> getVideoPosts(int pageIndex) {
        return postMapper.getVideoPosts(pageIndex);
    }

    @Override
    public List<Post> getAllPosts(int pageIndex) {
        return postMapper.getAllPosts(pageIndex);
    }

    @Override
    public List<Post> getPostsByPostState(int postState, int pageIndex) {
        return postMapper.getPostsByPostState(postState,pageIndex);
    }

    @Override
    public List<Post> getAllPostsWithoutPage() {
        return postMapper.getAllPostsWithoutPage();
    }

    @Override
    public Post getPostBypostId(int postId) {
        return postMapper.getPostBypostId(postId);
    }

    @Override
    public int updatePost(int postId, String postTitle, String postContent) {
        return postMapper.updatePost(postId, postTitle, postContent);
    }

    @Override
    public int updateChatPost(int postId, String postTitle, String postChat) {
        return postMapper.updateChatPost(postId,postTitle,postChat);
    }

    @Override
    public int updatePostState(int postId, int postState) {
        return postMapper.updatePostState(postId,postState);
    }

    @Override
    public int deletePost(int postId) {
        return postMapper.deletePost(postId);
    }

    @Override
    public int getPostsCountByPostType(int postType) {
        return postMapper.getPostsCountByPostType(postType);
    }

    @Override
    public int addArticlePost(String postTitle, int postUserId, String postContent) {
        return postMapper.addArticlePost(postTitle,postUserId,postContent);
    }

    @Override
    public int addChatPost(String postTitle, int postUserId, String postChat) {
        return postMapper.addChatPost(postTitle,postUserId,postChat);
    }

    @Override
    public int addImagePosts(String postTitle, int postUserId, String postContent, String postImage) {
        return postMapper.addImagePosts(postTitle,postUserId,postContent,postImage);
    }

    @Override
    public int addVideoPosts(String postTitle, int postUserId, String postContent, String postVideo) {
        return postMapper.addVideoPosts(postTitle,postUserId,postContent,postVideo);
    }

    @Override
    public int getPostsCountByPostState(int postState) {
        return postMapper.getPostsCountByPostState(postState);
    }

    @Override
    public List<Post> searchPost(String postTitle, int pageIndex) {
        return postMapper.searchPost(postTitle,pageIndex);
    }

    @Override
    public int searchPostCount(String postTitle) {
        return postMapper.searchPostCount(postTitle);
    }

    @Override
    public int postHitsUp(int postId) {
        return postMapper.postHitsUp(postId);
    }
}
