## xxl-job添加到springboot项目
### xxl-job-admin的部署
1.下载https://github.com/xuxueli/xxl-job最新版本
2. 在MySQL数据库中执行 doc/db/tables_xxl_job.sql文件，初始数据库
3. 修改xxl-job-admin中的application.properties中
```
 ###端口修改
 server.port=8780 
 ###数据库连接修改
 spring.datasource.url=
 spring.datasource.username=
 spring.datasource.password= 
```
4. 修改xxl-job-admin中的logback.xml日志路径

```
<property name="log.path" value="/logs/xxl-job/xxl-job-admin.log"/>
```

5. 执行maven命令，install进行打包
6. 将xxl-job-admin.jar部署到Linux服务器，开通上文中的端口
7. 访问http://服务器地址：端口/xxl-job-admin，初始密码admin/123456

### 执行器（业务服务端）
1. 加入xxl-job的maven依赖
```
<!-- xxl-job-core -->
<dependency>
    <groupId>com.xuxueli</groupId>
    <artifactId>xxl-job-core</artifactId>
    <version>2.3.1</version>
</dependency>
```
2. 配置文件中添加配置参数
```
xxl:
    job:
        accessToken:
        executor:
            appname: yuanxintest
            address:
            ip:
            port: 9999
            logpath: /logs/xxl-job/jobhandler
            logretentiondays: 30
        admin:
            addresses: http://127.0.0.1:8780/xxl-job-admin
```
3. 复制demo中的XxlJobConfig配置文件到项目中
4. 编写定时任务
类需要注解 @Component
方法上需要注解@XxlJob("hello")

5. 业务服务部署服务器时候，需要开通端口9999，否则出现调用失败错误
6. 如果是多个业务服务，需要不通的端口区别