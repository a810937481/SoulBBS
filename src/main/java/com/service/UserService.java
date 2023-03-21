package com.service;

import com.entity.Post;
import com.entity.User;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

public interface UserService {

    User getUserByUid(String userUid);

    User getUserById(int userId);

    String getUserUidByUid(String Uid);

    String getUserNameByName(String Name);

    String getUserEmailByUid(String Uid);

    String getUserCreateTimeById(int userId);

    String getUserAvatarByUid(String Uid);

    int getUserFollowsCountById(int userId);

    int getUserFansCountById(int userId);

    int getUserPostsCountById(int userId);

    int addUser(String userUid,
                String userPassword,
                String userName,
                String userEmail);

    int updateUserPassword(String userPassword,
                           String userUid);

    int updateUsrAvatarByUid(String userAvatar,
                             String Uid);

    List<User> getAllUser(int pageIndex);

    int updateUserState(int userId,
                        int userState);

    int userCount();

}
