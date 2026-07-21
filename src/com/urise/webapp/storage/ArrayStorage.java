package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/* **
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private final Resume[] storage = new Resume[10000];
    private int size = 0;

    public void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    public void save(Resume r) {


        int index = getIndex(r.getUuid());

        if (index != -1) {
            System.out.println("Resume " + r.getUuid() + "already exists");
        } else if (size >= storage.length) {
            System.out.println("Storage overflow");
        } else {
            storage[size] = r;
            size++;
        }

    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("Resume " + uuid + " not exist");
            return null;
        }

        return storage[index];


    }

    public void update(Resume r) {

        int index = getIndex(r.getUuid());
        if (index == -1) {
            System.out.println("Resume " + r.getUuid() + " not exist");
            return;
        }
        storage[index] = r;

    }

    public void delete(String uuid) {
        int index = getIndex(uuid);

        if (index == -1) {
            System.out.println("Resume " + uuid + " not exist");
            return;
        }
        for (int i = index; i < size - 1; i++) {
            storage[i] = storage[i + 1];
        }
        storage[size - 1] = null;
        size--;

    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        Resume[] result = new Resume[size];
        for (int i = 0; i < size; i++) {
            result[i] = storage[i];
        }
        return result;
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
