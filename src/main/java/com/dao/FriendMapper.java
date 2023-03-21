package com.dao;


import com.entity.Friend;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FriendMapper {

    int addFriend(@Param(value = "friendsUserId") int friendsUserId,
                  @Param(value = "friendsFollowedId") int friendsFollowedId);

    int deleteFriend(@Param(value = "friendsUserId") int friendsUserId,
                     @Param(value = "friendsFollowedId") int friendsFollowedId);

    int insureFollow(@Param(value = "friendsUserId") int friendsUserId,
                     @Param(value = "friendsFollowedId") int friendsFollowedId);

    List<Friend> findFollow(@Param(value = "friendsUserId") int friendsUserId);

    List<Friend> findFan(@Param(value = "friendsFollowedId") int friendsFollowedId);

}
