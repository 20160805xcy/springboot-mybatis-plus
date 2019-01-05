package com.xcy.springbootmybatisplus.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.xcy.springbootmybatisplus.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author xcy
 * @date 2018/12/19 11:47
 * @description UserMapper 必须继承Plus的BaseMapper<T>
 * @since V1.0.0
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    List<User> getUserList();
}
