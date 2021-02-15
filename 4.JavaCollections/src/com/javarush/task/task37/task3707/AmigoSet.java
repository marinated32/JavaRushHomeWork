package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class AmigoSet<E> extends AbstractSet<E> implements Cloneable, Serializable, Set<E> {
    private static final Object PRESENT = new Object ();
    private transient HashMap<E, Object> map;

    public AmigoSet() {
        this.map = new HashMap<> (  );
    }

    public AmigoSet(Collection<? extends E> collection) {
        int capacity = Math.max ( 16, (int) Math.floor(collection.size() / .75f) + 1 );
        this.map = new HashMap<> ( capacity );

        for (E col: collection) {
            map.put(col, PRESENT);
        }
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject ();
        s.writeInt(HashMapReflectionHelper.<Integer>callHiddenMethod(map, "capacity"));
        s.writeFloat(HashMapReflectionHelper.<Float>callHiddenMethod(map, "loadFactor"));

        s.writeInt(map.size());

        for (E e: map.keySet ()) {
            s.writeObject ( e );
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject ();
        int capacity = s.readInt ();
        float loadFactor = s.readFloat ();
        map = new HashMap<>( capacity, loadFactor );
        int size = s.readInt ();

        for (int i = 0; i < size; i++) {
            E key = (E) s.readObject ();
            map.put ( key, PRESENT );
        }
    }

    @Override
    public Object clone() {
        AmigoSet<E> clone;
        try {
            clone = (AmigoSet<E>) super.clone ();
            clone.map = (HashMap) this.map.clone ();
        } catch (Error e) {
            throw new InternalError ();
        } catch (Exception e) {
            throw new InternalError ();
        }
        return clone;
    }

    @Override
    public boolean add(E e) {
        return null == map.put(e,PRESENT);
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet ().iterator ();
    }

    @Override
    public int size() {
        return map.size ();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty ();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey ( o );
    }

    @Override
    public void clear() {
        map.clear ();
    }

    @Override
    public boolean remove(Object o) {
        return null == map.remove ( o );
    }
}
