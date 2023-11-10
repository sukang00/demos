## 方式一
启动时候添加
java -jar  minaserver-1.0-SNAPSHOT.jar --spring.config.additional-location=./config/application-local.yml

## 方式二
代码中添加
```
    System.setProperty("spring.config.additional-location", "./config/application-local.yml");
    SpringApplication.run(NioSocketAcceptorExample.class,args);
```

## spring.config.additional-location和spring.config.location区别
spring.config.location是替换主配置文件
spring.config.additional-location追加配置内容
### 外部配置执行顺序
spring.config.location > spring.profiles.active > spring.config.additional-location > 默认的 application.proerties。

