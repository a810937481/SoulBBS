package com.service;

import com.entity.Admin;
import com.entity.AdminRights;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminService {

    Admin getAdminByUid(String adminUid);

    Admin getAdminById(int adminId);

    List<Admin> getAllAdmin(int pageIndex);

    AdminRights getAdminRights(int rightsAdminId);

    int addAdmin(String adminUid,
                 String adminPassword,
                 String adminName);

    int addNewRights(int rightsAdminId);

    int onAdminRights(int rightsAdminId);

    int offAdminRights(int rightsAdminId);

    int getAdminCounts();

}
