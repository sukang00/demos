package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2023/3/4 13:58
 */
@Data
public class ChatCompletionsModel {

    private String model;

    private List<Item> messages;


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Accessors(chain = true)
    public static class Item{
        private String role;

        private String content;

    }

}
