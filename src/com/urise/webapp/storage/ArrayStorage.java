package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;

    public void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    public void save(Resume r) {
        if (size >= storage.length) {
            System.out.println("Storage overflow");
            return;
        }
        String uuid = r.getUuid();
        int isIndex = getIndex(uuid);

        if (isIndex >= 0) {
            System.out.println("Resume " + uuid + "already exists");
        } else {
            storage[size] = r;
            size++;
        }

    }

    public Resume get(String uuid) {
        int isIndex = getIndex(uuid);
        if (isIndex >= 0) {
            return storage[isIndex];
        }

        System.out.println("Resume " + uuid + " not exist");
        return null;
    }

    public void update(Resume r) {
        String uuid = r.getUuid();
        int isIndex = getIndex(uuid);
        if (isIndex >= 0) {
            storage[isIndex] = r;
            return;
        } else {
            System.out.println("Resume " + r.getUuid() + " not exist");
        }

    }

    public void delete(String uuid) {
        int isIndex = getIndex(uuid);
        if (isIndex >= 0) {
            for (int i = isIndex; i < size - 1; i++) {
                storage[i] = storage[i + 1];
            }
            storage[size - 1] = null;
            size--;
        } else {
            System.out.println("Resume " + uuid + " not exist");
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {

        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    private int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i] != null && uuid.equals(storage[i].getUuid())) {
                return i;

            }
        }
        return -1;
    }

}
