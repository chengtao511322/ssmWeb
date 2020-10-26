package com.ct.service.impl;

import com.ct.Province;
import com.ct.dao.IProvinceDao;
import com.ct.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProvinceServiceImpl implements IProvinceService {


    @Autowired
    IProvinceDao provinceDao;

    /**
     * 查询所有的省份
     * @return
     */
    @Override
    public List<Province> findAll() {
        return provinceDao.findAll();
    }
}
