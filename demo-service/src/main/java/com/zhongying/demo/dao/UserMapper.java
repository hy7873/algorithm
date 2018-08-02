package com.zhongying.demo.dao;


import com.zhongying.demo.model.User;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface UserMapper extends Mapper<User> {

    List<Map> findUsersByParams(Map params);

    List<Map> queryUserInfo(Map params);

    int queryUserInfoCount(Map params);

    List<Map> queryUserInfoAll(Map params);

    int queryUserInfoCountAll(Map params);

    /**
     * 根据平台类型 统计累计历史注册用户数
     *
     * @return
     */
    int byRegisterNumber();

    Integer byUserStatus(@Param("userCode") String userCode, @Param("platform") String platform);

    int updateByUserCode(Map<String, Object> user);

	List<Map<String, Object>> batchFindUserByParams(List<Map<String, String>> list);

    Map queryUserIsExists(Map params);

    int updateUserById(User user);

    User getByCondition(User user);

    /**
     *修改,未经校验,禁止直接调用
     */
    Integer update(User model);

    List<Map<String, Object>> selectByUserCodes(@Param("userCodes") List<String> userCodes);
}