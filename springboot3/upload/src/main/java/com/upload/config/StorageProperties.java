package com.upload.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author sukang
 * @date 2023-11-28
 * @description
 */
@ConfigurationProperties("storage")
public class StorageProperties {

    /**
     * Folder location for storing files
     */
    private String location = "upload-dir";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
