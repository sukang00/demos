package com.upload.execption;

/**
 * @author sukang
 * @date 2023-11-28
 * @description
 */
public class StorageException extends RuntimeException  {
    public StorageException(String message) {
        super(message);
    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
