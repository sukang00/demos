package org.example.model;

import com.dtflys.forest.annotation.Query;
import lombok.Data;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2023/3/4 13:43
 */
@Data
public class CompletionsModel {

    private String model;
    private String prompt;
    private Integer temperature;
    private Integer max_tokens;
}
