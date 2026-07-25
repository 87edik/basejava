package com.urise.webapp.exception;

public class NotExistStorageException extends StorageException {
    public NotExistStorageException(String uuid) {
        super("This resume " + uuid + " not exist", uuid);
    }
}
