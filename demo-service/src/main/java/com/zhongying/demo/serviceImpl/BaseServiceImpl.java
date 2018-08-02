package com.zhongying.demo.serviceImpl;

import com.zhongying.demo.dao.UserMapper;
import com.zhongying.demo.model.User;
import com.zhongying.demo.service.BaseService;
import com.zhongying.demo.util.JacksonUtil;
import com.zhongying.demo.util.datasource.DataSourceContextHolder;
import com.zhongying.demo.util.datasource.DynamicDataSourceAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/7/30.
 */
@Service("baseService")
@DynamicDataSourceAnnotation
public class BaseServiceImpl implements BaseService {

    @Autowired
    private UserMapper userMapper;

    @DynamicDataSourceAnnotation(dataSource = DataSourceContextHolder.DATA_SOURCE_A)
    public void changeDataSourceA() {
        User user = userMapper.selectByPrimaryKey(1L);
        System.out.println("切换数据源serviceImple" + JacksonUtil.bean2Json(user));
    }

    @DynamicDataSourceAnnotation(dataSource = DataSourceContextHolder.DATA_SOURCE_B)
    public void changeDataSourceB() {
        User user = userMapper.selectByPrimaryKey(1L);
        System.out.println("切换数据源serviceImple" + JacksonUtil.bean2Json(user));
    }
}
