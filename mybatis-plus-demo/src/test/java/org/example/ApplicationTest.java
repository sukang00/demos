package org.example;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.entity.User;
import org.example.mapper.UserMapper;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2023/1/4 10:23
 */
@SpringBootTest
public class ApplicationTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }

    @Test
    public void testPage(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("age",18);
        Page<User> userPage = userMapper.selectPage(new Page<User>(1, 2), queryWrapper);
        System.out.println("总页数： " + userPage.getPages());
        System.out.println("总记录数： " + userPage.getTotal());
        userPage.getRecords().forEach(System.out::println);
    }

    /**
     * 测试(Wrappers.lambdaQuery 使用
     */
    @Test
    public void testList(){
        List<User> users = userMapper.selectList(Wrappers.lambdaQuery(User.class).ge(User::getAge, 18).le(User::getAge,24));
        users.forEach(user -> System.out.println(user.getName()));
    }

    /**
     * 测试@Data
     * @Accessors(chain = true) 使用
     */
    @Test
    public void testUpdate(){
        User user = userMapper.selectOne(Wrappers.lambdaQuery(User.class).eq(User::getId, 1));
        user.setName("测试").setEmail("ceshi@189.com").setAge(60);
        userMapper.updateById(user);
        User userQuery = userMapper.selectOne(Wrappers.lambdaQuery(User.class).eq(User::getId, 1));
        System.out.println(userQuery.toString());
    }
    @Test
    public void testSelectLast(){
        List<User> users = userMapper.selectList(Wrappers.lambdaQuery(User.class).ge(User::getAge, 18).le(User::getAge,24).last("order by id desc limit 2"));
        users.forEach(user -> System.out.println(user.getId()+ ":" + user.getName()));
    }
    @Test
    public void testSelectApply(){
        List<User> users = userMapper.selectList(Wrappers.lambdaQuery(User.class).ge(User::getAge, 18).le(User::getAge,24).apply("name = {0}", "Sa"));
        users.forEach(user -> System.out.println(user.getId()+ ":" + user.getName()));
    }
    @Test
    public void testSelect1(){
        List<User> users = userMapper.selectList(Wrappers.lambdaQuery(User.class).select(User::getName).ge(User::getAge, 18).le(User::getAge,24));
        users.forEach(user -> System.out.println(user.getId()+ ":" + user.getName()));
    }
    @Test
    public void testSelectLike(){
        List<User> users = userMapper.selectList(Wrappers.lambdaQuery(User.class).like(User::getName,"T"));
        users.forEach(user -> System.out.println(user.getId()+ ":" + user.getName()));
    }
    @Test
    public void testSelectLikeRight(){
        List<User> users = userMapper.selectList(Wrappers.lambdaQuery(User.class).likeRight(User::getName,"T"));
        users.forEach(user -> System.out.println(user.getId()+ ":" + user.getName()));
    }
}
