package com.dao;

import com.entity.Admin;
import com.entity.AdminRights;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdminMapper {

    Admin getAdminByUid(@Param(value = "adminUid") String adminUid);

    Admin getAdminById(@Param(value = "adminId") int adminId);

    List<Admin> getAllAdmin(@Param(value = "pageIndex") int pageIndex);

    AdminRights getAdminRights(@Param(value = "rightsAdminId") int rightsAdminId);

    int addAdmin(@Param(value = "adminUid") String adminUid,
                 @Param(value = "adminPassword") String adminPassword,
                 @Param(value = "adminName") String adminName);

    int addNewRights(@Param(value = "rightsAdminId") int rightsAdminId);

    int onAdminRights(@Param(value = "rightsAdminId") int rightsAdminId);

    int offAdminRights(@Param(value = "rightsAdminId") int rightsAdminId);

    int getAdminCounts();

}
