package org.example;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2023/1/4 13:41
 */
@SpringBootTest
public class FastAutoGeneratorTest {

    private String url;
    private String username;
    private String password;

    @Before
    public void befor(){
        url = "jdbc:mysql://127.0.0.1:3306/mybatis_plus?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8";
        username = "root";
        password = "root";
    }
    @Test
    public void genCode(){
        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author("sukang") // 设置作者
//                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("D://github//demos//mybatis-plus-demo//src//main//java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("org.example") // 设置父包名
//                            .moduleName("system") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "D://github//demos//mybatis-plus-demo//src//main//resources//mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("user") // 设置需要生成的表名
                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
