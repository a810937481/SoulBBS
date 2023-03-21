package com.dao;

import com.entity.Post;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PostMapper {

    List<Post> getPostsByUserId(@Param(value = "userId") int userId,
                                @Param(value = "pageIndex") int pageIndex);

    List<Post> getArticlePosts(@Param(value = "pageIndex") int pageIndex);

    List<Post> getChatPosts(@Param(value = "pageIndex") int pageIndex);

    List<Post> getImagePosts(@Param(value = "pageIndex") int pageIndex);

    List<Post> getVideoPosts(@Param(value = "pageIndex") int pageIndex);

    List<Post> getAllPosts(@Param(value = "pageIndex") int pageIndex);

    List<Post> getPostsByPostState(@Param(value = "postState") int postState,
            @Param(value = "pageIndex") int pageIndex);

    List<Post> getAllPostsWithoutPage();

    Post getPostBypostId(@Param(value = "postId") int postId);

    int updatePost(@Param(value = "postId") int postId,
                   @Param(value = "postTitle") String postTitle,
                   @Param(value = "postContent") String postContent);

    int updateChatPost(@Param(value = "postId") int postId,
                   @Param(value = "postTitle") String postTitle,
                   @Param(value = "postChat") String postChat);

    int updatePostState(@Param(value = "postId") int postId,
                        @Param(value = "postState") int postState);

    int deletePost(@Param(value = "postId") int postId);

    int getPostsCountByPostType(@Param(value = "postType") int postType);

    int addArticlePost(@Param(value = "postTitle") String postTitle,
                       @Param(value = "postUserId") int postUserId,
                       @Param(value = "postContent") String postContent);

    int addChatPost(@Param(value = "postTitle") String postTitle,
                    @Param(value = "postUserId") int postUserId,
                    @Param(value = "postChat") String postChat);

    int addImagePosts(@Param(value = "postTitle") String postTitle,
                      @Param(value = "postUserId") int postUserId,
                      @Param(value = "postContent") String postContent,
                      @Param(value = "postImage") String postImage);

    int addVideoPosts(@Param(value = "postTitle") String postTitle,
                      @Param(value = "postUserId") int postUserId,
                      @Param(value = "postContent") String postContent,
                      @Param(value = "postVideo") String postVideo);

    int getPostsCountByPostState(@Param(value = "postState") int postState);

    List<Post> searchPost(@Param(value = "postTitle") String postTitle, @Param(value = "pageIndex") int pageIndex);

    int searchPostCount(@Param(value = "postTitle") String postTitle);

    int postHitsUp(@Param(value = "postId") int postId);

}
