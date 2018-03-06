package com.middleware.data.hbase.data.hbase.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.middleware.data.hbase.data.hbase.demo.dao.HbaseAccountInfoMapper;
import com.middleware.data.hbase.data.hbase.demo.entity.UserInfo;

/**
 * Created by DOUBLE on 2017/04/11.
 *
 * @author DOUBLE
 * @since 2017/04/11
 */
@Service("hbaseAccountInfoService")
public class HbaseAccountInfoService {

    @Autowired
    HbaseAccountInfoMapper hbaseAccountInfoMapper;

    public UserInfo getUserInfo(String table, String family, String rowKey) {
        return hbaseAccountInfoMapper.findUserInfoByEntity(table, family, rowKey);
    }

    public List<UserInfo> listUserInfos(String tableName, String family) {
        return hbaseAccountInfoMapper.findAll(tableName, family);
    }
}

