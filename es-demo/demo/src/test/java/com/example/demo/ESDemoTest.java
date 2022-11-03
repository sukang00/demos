package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.example.demo.entity.UserEntity;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.IndicesClient;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.core.TimeValue;
import org.elasticsearch.xcontent.XContentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2022/11/3 11:18
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ESDemoTest {


    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Test
    public void testCreateDoc() throws IOException {

        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);
        userEntity.setAdress("地址abc");
        userEntity.setAge(10);
        userEntity.setName("李四");
        // 创建好index请求
        IndexRequest indexRequest = new IndexRequest("architecture_index");
        // 设置索引
        indexRequest.id("5");
        // 设置超时时间（默认）
        indexRequest.timeout(TimeValue.timeValueSeconds(5));
        // 往请求中添加数据
        indexRequest.source(JSON.toJSONString(userEntity), XContentType.JSON);
        //执行添加请求
        IndexResponse indexResponse = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
        System.out.println(indexResponse);
    }

    @Test
    public void getDoc() throws IOException {

        //获得查询索引的请求对象
        GetRequest gerRequest = new GetRequest("architecture_index").id("5");
        //获得文档对象
        GetResponse doc = restHighLevelClient.get(gerRequest, RequestOptions.DEFAULT);
        //获得文档数据
        System.out.println(doc.getSourceAsString());
    }

    @Test
    public void delDoc() throws IOException {

        //获得删除的索引请求对象
        DeleteRequest delRequest = new DeleteRequest("architecture_index").id("5");
        //删除文档
        DeleteResponse delete = restHighLevelClient.delete(delRequest, RequestOptions.DEFAULT);
        System.out.println(delete.getIndex());
    }

    @Test
    public void delIndex() throws IOException {

        IndicesClient indices = restHighLevelClient.indices();
        DeleteIndexRequest delReq = new DeleteIndexRequest("architecture_index");
        AcknowledgedResponse delete = indices.delete(delReq, RequestOptions.DEFAULT);
        System.out.println(delete.isAcknowledged());
    }

    @Test
    public void contextLoads() throws IOException {

        //查询mysql中所有数据
        List<UserEntity> userEntities = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            UserEntity user = new UserEntity();
            user.setId(Long.valueOf(i+1));
            user.setName("李四"+i);
            user.setAge(10+i);
            user.setAdress("北京，西安"+i);
            userEntities.add(user);
        }
        //创建批量处理对象
        BulkRequest bulkRequest = new BulkRequest();

        //循环添加新增处理请求
        for (UserEntity user : userEntities) {

            String architecturJson = JSON.toJSONString(user);
            IndexRequest indexRequest = new IndexRequest("architecture_index").id(user.getId() + "").source(architecturJson, XContentType.JSON);
            bulkRequest.add(indexRequest);
        }

        //提交批量处理对象
        BulkResponse bulk = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);

        //查看添加状态
        System.out.println(bulk.status());

    }
}
