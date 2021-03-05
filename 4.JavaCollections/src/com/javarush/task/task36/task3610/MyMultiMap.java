package com.javarush.task.task36.task3610;

import java.io.Serializable;
import java.util.*;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        //напишите тут ваш код
        int size = 0;

        if (!map.isEmpty ()) {
            for (List list: map.values ()) {
                size += list.size ();
            }
        }

        return size;
    }

    @Override
    public V put(K key, V value) {
        if (!map.containsKey ( key )) {
            map.put ( key, new ArrayList<V> (  ) {{
                add(value);
            }} );
            return null;
        } else {
            if (map.get ( key ).size () < repeatCount) {
                map.get ( key ).add ( value );
                return map.get ( key ).get ( map.get(key).size() - 2 );
            } else {
                V toReturn = map.get ( key ).get ( repeatCount - 1 );
                map.get ( key ).remove ( 0 );
                map.get ( key ).add ( value );
                return toReturn;
            }
        }
    }

    @Override
    public V remove(Object key) {
        //напишите тут ваш код
        if (map.containsKey ( key )) {
            V toRemove = map.get ( key ).get ( 0 );
            map.get ( key ).remove ( 0 );

            if (map.get ( key ).size () == 0) {
                map.remove ( key );
            }
            return toRemove;
        }
        return null;
    }

    @Override
    public Set<K> keySet() {
        //напишите тут ваш код
        Set<K> set = map.keySet ();
        return set;
    }

    @Override
    public Collection<V> values() {
        //напишите тут ваш код
        List<V> list = new ArrayList<V> (  );
        for (List li: map.values ()) {
            list.addAll ( li );
        }

        return list;
    }

    @Override
    public boolean containsKey(Object key) {
        //напишите тут ваш код
        return map.containsKey ( key );
    }

    @Override
    public boolean containsValue(Object value) {
        //напишите тут ваш код
        for (List list: map.values ()) {
            if (list.contains ( value )) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}