package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2023/3/4 17:04
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImagesGenModel {

    private String prompt;
    private Integer n;

    private String size;

}
