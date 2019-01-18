package com.hy.demo.util;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @Author: wanghai
 * @Date:2019/1/18 14:55
 * @Copyright:reach-life
 * @Description:
 */
public class UnSafeUtil {

    /**
     * 设置对象属性的值
     * @param object
     * @param fieldName
     * @param fieldValue
     * @return
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    public static boolean setFieldValue(Object object,String fieldName,Object fieldValue) throws NoSuchFieldException, IllegalAccessException {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);

        Field field = object.getClass().getDeclaredField(fieldName);
        //对象属性的地址
        long offset = unsafe.objectFieldOffset(field);
        boolean b = unsafe.compareAndSwapObject(object,offset,getFieldValue(object,fieldName),fieldValue);
        return b;
    }


    /**
     *
     * @param object
     * @param field
     * @param fieldValue
     * @return
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    public static boolean setFieldValue(Object object,Field field,Object fieldValue) throws NoSuchFieldException, IllegalAccessException {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);
        //对象属性的地址
        long offset = unsafe.objectFieldOffset(field);
        boolean b = unsafe.compareAndSwapObject(object,offset,getFieldValue(object,field),fieldValue);
        return b;
    }

    /**
     * 获取对象属性的值
     * @param object
     * @param fieldName
     * @return
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    public static Object getFieldValue(Object object,String fieldName) throws NoSuchFieldException, IllegalAccessException {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);

        Field field = object.getClass().getDeclaredField(fieldName);

        //对象属性的地址
        long offset = unsafe.objectFieldOffset(field);
        return unsafe.getObject(object,offset);
    }


    public static Field getFieldFromObject(Object object,String fieldName) {
        Field field = null;
        Class tempClass = object.getClass();
        while (tempClass != null && !tempClass.getName().toLowerCase().contains("object")) {
            Field[] fields = tempClass.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                System.out.println(fields[i].getName());
                if (fieldName.equals(fields[i].getName())) {
                    return fields[i];
                }
            }
            tempClass = tempClass.getSuperclass();
        }
        return field;
    }


    /**
     *
     * @param object
     * @param field
     * @return
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    public static Object getFieldValue(Object object,Field field) throws NoSuchFieldException, IllegalAccessException {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);
        //对象属性的地址
        long offset = unsafe.objectFieldOffset(field);
        return unsafe.getObject(object,offset);
    }
}
