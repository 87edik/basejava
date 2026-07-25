package com.urise.webapp.storage;

import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

public abstract class AbstractArrayStorageTest {
    protected Storage storage;

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";

    // ДОБАВИЛИ КОНСТРУКТОР: через него JUnit свяжет наследников с этим классом
    protected AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @BeforeEach
    public void setUp() {
        storage.clear();

        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @org.junit.jupiter.api.Test
    void size() {
        Assertions.assertEquals(3, storage.size());
    }

    @org.junit.jupiter.api.Test
    void get() {
    }

    @org.junit.jupiter.api.Test
    void update() {
    }

    @org.junit.jupiter.api.Test
    void delete() {
    }

    @org.junit.jupiter.api.Test
    void save() {
    }

    @org.junit.jupiter.api.Test
    void clear() {
    }

    @org.junit.jupiter.api.Test
    void getAll() {
    }

    @org.junit.jupiter.api.Test
    void getNotExist() {
        org.junit.jupiter.api.Assertions.assertThrows(NotExistStorageException.class, () -> {
            storage.get("dummy");
        });
    }

    @org.junit.jupiter.api.Test
    void saveOverflow() {
        storage.clear(); // Очищаем массив перед тестом

        // Берем лимит из боевого класса AbstractArrayStorage (у вас там 100000)
        int storageLimit = AbstractArrayStorage.STORAGE_LIMIT;

        // 1. Заполняем массив до предела в обычном режиме
        try {
            for (int i = 0; i < storageLimit; i++) {
                storage.save(new Resume("uuid_" + i));
            }
        } catch (com.urise.webapp.exception.StorageException e) {
            // Если упало раньше времени — тест провален
            org.junit.jupiter.api.Assertions.fail("Переполнение произошло до достижения лимита: " + e.getMessage());
        }

        // 2. Хранилище полное. Следующий элемент обязан вызвать StorageException
        org.junit.jupiter.api.Assertions.assertThrows(com.urise.webapp.exception.StorageException.class, () -> {
            storage.save(new Resume("overflow_uuid"));
        });
    }


}