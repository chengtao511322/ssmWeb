package com.ct.service;


import com.ct.Province;

import java.util.List;

public interface IProvinceService {

    /**
     * 查询所有省份列表
     */
    public List<Province> findAll();
}
