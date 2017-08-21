package com.em.service;

import com.em.model.Repair;
import com.github.pagehelper.PageInfo;

public interface RepairService {
	PageInfo<Repair> queryRepairPage(String repairId,int page,int rows);
    int repairAdd(Repair repair);
    Repair queryRepairById(int id);
    int updateRepair(Repair repair);
    int deleteRepair(int id);
    PageInfo<Repair> querRepairByName(String name,int page,int rows);
}
