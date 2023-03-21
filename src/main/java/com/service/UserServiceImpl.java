package com.service;

import com.dao.UserMapper;
import com.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByUid(String userUid) {
        User user = userMapper.getUserByUid(userUid);
        return user;
    }

    @Override
    public User getUserById(int userId) {
        User user = userMapper.getUserById(userId);
        return user;
    }

    @Override
    public String getUserUidByUid(String Uid) {
        String userUid = userMapper.getUserUidByUid(Uid);
        return userUid;
    }

    @Override
    public String getUserNameByName(String Name) {
        String userName = userMapper.getUserNameByName(Name);
        return userName;
    }

    @Override
    public String getUserEmailByUid(String Uid) {
        String userEmail = userMapper.getUserEmailByUid(Uid);
        return userEmail;
    }

    @Override
    public String getUserCreateTimeById(int userId) {
        return userMapper.getUserCreateTimeById(userId);
    }

    @Override
    public String getUserAvatarByUid(String Uid) {
        return userMapper.getUserAvatarByUid(Uid);
    }

    @Override
    public int getUserFollowsCountById(int userId) {
        return userMapper.getUserFollowsCountById(userId);
    }

    @Override
    public int getUserFansCountById(int userId) {
        return userMapper.getUserFansCountById(userId);
    }

    @Override
    public int getUserPostsCountById(int userId) {
        return userMapper.getUserPostsCountById(userId);
    }

    @Override
    public int addUser(String userUid, String userPassword, String userName, String userEmail) {
        return userMapper.addUser(userUid,userPassword,userName,userEmail);
    }

    @Override
    public int updateUserPassword(String userPassword, String userUid) {
        return userMapper.updateUserPassword(userPassword,userUid);
    }

    @Override
    public int updateUsrAvatarByUid(String userAvatar, String Uid) {
        return userMapper.updateUsrAvatarByUid(userAvatar,Uid);
    }

    @Override
    public List<User> getAllUser(int pageIndex) {
        return userMapper.getAllUser(pageIndex);
    }

    @Override
    public int updateUserState(int userId, int userState) {
        return userMapper.updateUserState(userId,userState);
    }

    @Override
    public int userCount() {
        return userMapper.userCount();
    }
}
