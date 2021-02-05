package com.javarush.task.task34.task3408;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.temporal.ValueRange;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<K, V> ();   //TODO add your code here

    public V getByKey(K key, Class<V> clazz) throws Exception {
        //TODO add your code here
        if (cache.containsKey ( key )) {
            return cache.get ( key );
        } else {
            cache.put ( key, (V) clazz.getConstructor ( key.getClass () ).newInstance ( key ) );
        }
        return null;
    }

    public boolean put(V obj) {
        //TODO add your code here
        try {
            Method method = obj.getClass ().getDeclaredMethod ( "getKey" );
            method.setAccessible ( true );
            cache.put ( (K) method.invoke ( obj ), obj );
            return true;
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
        }
        return false;
    }

    public int size() {
        return cache.size();
    }
}
