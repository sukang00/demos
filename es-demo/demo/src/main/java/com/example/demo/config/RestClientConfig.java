package com.example.demo.config;


import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2022/11/3 11:15
 */
@Configuration
public class RestClientConfig extends AbstractElasticsearchConfiguration {

    @Value("${es.clusterName}")
    private String clusterName;
    @Value("${es.servers}")
    private String servers;
    @Value("${es.port}")
    private int port;

    @Override
    @Bean
    public RestHighLevelClient elasticsearchClient() {

        final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo(servers + ":" + port)
                .build();
        return RestClients.create(clientConfiguration).rest();
    }
}
