package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected final static int STORAGE_LIMIT = 100000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public int size() {
        return size;
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
        doDelete(index);
//
        storage[size - 1] = null;
        size--;

    }

    public void save(Resume r) {


        int index = getIndex(r.getUuid());

        if (index >= 0) {
            System.out.println("Resume " + r.getUuid() + "already exists");
            return;
        }
        if (size >= STORAGE_LIMIT) {
            System.out.println("Storage overflow");
            return;
        }
        doSave(r, index);
        size++;


    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public Resume[] getAll() {

        return Arrays.copyOfRange(storage, 0, size);
    }

    protected abstract void doSave(Resume r, int index);

    protected abstract void doDelete(int index);

    protected abstract int getIndex(String uuid);


}
