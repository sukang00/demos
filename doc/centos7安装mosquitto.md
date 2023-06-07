## 参考地址
``https://blog.csdn.net/qq_34301871/article/details/93617204
https://blog.csdn.net/qq_43003434/article/details/120022386#:~:text=1.Mosquitto%E4%B8%8B%E8%BD%BD%E5%9C%B0%E5%9D%80%20http%3A%2F%2Fmosquitto.org%2Ffiles%2Fsource%2F.%20%E9%80%89%E6%8B%A9%E6%89%80%E9%9C%80%E8%A6%81%E7%9A%84%E7%89%88%E6%9C%AC%E4%B8%8B%E8%BD%BD%E5%8D%B3%E5%8F%AF%EF%BC%8C%E5%B0%86%E4%B8%8B%E8%BD%BD%E7%9A%84mosquitto-x.x.x.tar.gz%20%E4%B8%8A%E4%BC%A0%E5%88%B0centos7%20%2Fusr%2Flocal%2F%20%E6%96%87%E4%BB%B6%E5%A4%B9%E4%B8%AD%EF%BC%8C%E5%B9%B6%E8%A7%A3%E5%8E%8B%E5%88%B0mosquitto%E6%96%87%E4%BB%B6%E5%A4%B9%E4%B8%AD%E3%80%82%202.%E5%AE%89%E8%A3%85Mosquitto%20%EF%BC%881%EF%BC%89,%26%26%20make%20install%20%EF%BC%882%EF%BC%89%E5%AE%89%E8%A3%85%E5%AE%8C%E4%BB%A5%E5%90%8E%E5%88%87%E6%8D%A2%E5%88%B0%20%2Fetc%20%E7%9B%AE%E5%BD%95%E4%B8%8B%E6%9F%A5%E7%9C%8B%20%EF%BC%883%EF%BC%89%E5%88%87%E6%8D%A2%E5%88%B0%20%2Fetc%2Fmosquitto%E7%9B%AE%E5%BD%95%E4%B8%8B%EF%BC%8C%E6%89%A7%E8%A1%8C
``

### 第1步：添加 EPEL 软件库
-->> 执行命令：yum install https://dl.fedoraproject.org/pub/epel/epel-release-latest-7.noarch.rpm

-->> 查看结果：yum repolist all | grep enabled

### 第2步：安装 mosquitto
-->> 查找 mosquitto 软件包：yum list all | grep mosquitto

-->> 查看 mosquitto 信息： yum info mosquitto

-->> 安装 mosquitto 软件包： yum install mosquitto

-->> 查看安装结果：yum list installed | grep mosquitto


### 第3步：配置  
-->> 切换到 /etc/mosquitto目录下，执行
-->> cp mosquitto.conf.example mosquitto.conf

### 第4步
-->> 启动服务
	mosquitto -c /etc/mosquitto/mosquitto.conf -d

### 第5步
-->> 查看端口netstat -anp |grep 1883

