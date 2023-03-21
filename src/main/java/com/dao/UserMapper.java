package com.dao;

import com.entity.Post;
import com.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface UserMapper {

    User getUserByUid(@Param(value = "userUid") String userUid);

    User getUserById(@Param(value = "userId") int userId);

    String getUserUidByUid(@Param(value = "userUid") String userUid);

    String getUserNameByName(@Param(value = "userName") String userName);

    String getUserEmailByUid(@Param(value = "userUid") String userUid);

    String getUserCreateTimeById(@Param(value = "userId") int userId);

    String getUserAvatarByUid(@Param(value = "userUid") String userUid);

    List<User> getAllUser(@Param(value = "pageIndex") int pageIndex);

    int updateUserState(@Param(value = "userId") int userId,
                        @Param(value = "userState") int userState);

    int getUserFollowsCountById(@Param(value = "userId") int userId);

    int getUserFansCountById(@Param(value = "userId") int userId);

    int getUserPostsCountById(@Param(value = "userId") int userId);

    int addUser(@Param(value = "userUid") String userUid,
                @Param(value = "userPassword") String userPassword,
                @Param(value = "userName") String userName,
                @Param(value = "userEmail") String userEmail);

    int updateUserPassword(@Param(value = "userPassword") String userPassword,
                           @Param(value = "userUid") String userUid);

    int updateUsrAvatarByUid(@Param(value = "userAvatar") String userAvatar,
                             @Param(value = "userUid") String userUid);

    int userCount();

}
