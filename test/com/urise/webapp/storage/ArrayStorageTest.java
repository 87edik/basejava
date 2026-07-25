package com.urise.webapp.storage;

public class ArrayStorageTest extends AbstractArrayStorageTest {

    public ArrayStorageTest() {
        super(new ArrayStorage());
    }

    // Явно показываем IDEA, какие тесты тут есть
    @org.junit.jupiter.api.Test
    @Override
    void size() {
        super.size();
    }

    @org.junit.jupiter.api.Test
    @Override
    void getNotExist() {
        super.getNotExist();
    }

    @org.junit.jupiter.api.Test
    @Override
    void saveOverflow() {
        super.saveOverflow();
    }

    @org.junit.jupiter.api.Test
    @Override
    void get() {
        super.get();
    }

    @org.junit.jupiter.api.Test
    @Override
    void update() {
        super.update();
    }

    @org.junit.jupiter.api.Test
    @Override
    void delete() {
        super.delete();
    }

    @org.junit.jupiter.api.Test
    @Override
    void save() {
        super.save();
    }

    @org.junit.jupiter.api.Test
    @Override
    void clear() {
        super.clear();
    }

    @org.junit.jupiter.api.Test
    @Override
    void getAll() {
        super.getAll();
    }
}
