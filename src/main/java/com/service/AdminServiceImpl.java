package com.service;

import com.dao.AdminMapper;
import com.entity.Admin;
import com.entity.AdminRights;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminServiceImpl implements AdminService{

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin getAdminByUid(String adminUid) {
        return adminMapper.getAdminByUid(adminUid);
    }

    @Override
    public Admin getAdminById(int adminId) {
        return adminMapper.getAdminById(adminId);
    }

    @Override
    public List<Admin> getAllAdmin(int pageIndex) {
        return adminMapper.getAllAdmin(pageIndex);
    }

    @Override
    public AdminRights getAdminRights(int rightsAdminId) {
        return adminMapper.getAdminRights(rightsAdminId);
    }

    @Override
    public int addAdmin(String adminUid, String adminPassword, String adminName) {
        return adminMapper.addAdmin(adminUid,adminPassword,adminName);
    }

    @Override
    public int addNewRights(int rightsAdminId) {
        return adminMapper.addNewRights(rightsAdminId);
    }

    @Override
    public int onAdminRights(int rightsAdminId) {
        return adminMapper.onAdminRights(rightsAdminId);
    }

    @Override
    public int offAdminRights(int rightsAdminId) {
        return adminMapper.offAdminRights(rightsAdminId);
    }

    @Override
    public int getAdminCounts() {
        return adminMapper.getAdminCounts();
    }
}
