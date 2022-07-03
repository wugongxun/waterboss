package com.wgx.waterboss.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wgx.waterboss.bean.Owners;

public interface OwnersMapper extends BaseMapper<Owners> {
//    Owners selectById(Long id);
    void insertOwners(Owners owners);
}
