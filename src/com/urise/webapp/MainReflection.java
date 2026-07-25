package com.urise.webapp;

import com.urise.webapp.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MainReflection {
    // Добавьте эти исключения в секцию throws вашего метода main
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, java.lang.reflect.InvocationTargetException {

        Resume r = new Resume();
        Field field = r.getClass().getDeclaredFields()[0];
        field.setAccessible(true);
        System.out.println(field.getName());
        System.out.println(field.get(r));
        field.set(r, "new uuid");
        System.out.println(r);

        // 1. Получаем класс-зеркало объекта r
        Class<? extends Resume> clazz = r.getClass();

        // 2. Достаем метаданные метода "toString" (он public, параметров нет)
        Method toStringMethod = clazz.getMethod("toString");

        // 3. Вызываем (invoke) метод над объектом r
        Object reflectionResult = toStringMethod.invoke(r);

        // 4. Выводим результат в консоль
        System.out.println("Вызов toString через рефлексию: " + reflectionResult);
    }
}
