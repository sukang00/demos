package org.example.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.sql.Wrapper;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author sukang
 * @since 2023-01-04
 */
public interface UserMapper extends BaseMapper<User> {


}
