package com.urise.webapp.exception;

public class ExistStorageException extends StorageException {
    public ExistStorageException(String uuid) {
        super("This resume " + uuid + " already exist", uuid);
    }
}
