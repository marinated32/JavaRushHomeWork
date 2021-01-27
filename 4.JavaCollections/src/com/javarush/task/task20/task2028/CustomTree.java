package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/

public class CustomTree extends AbstractList<String> implements Cloneable, Serializable{
    Entry<String> root;
    public int countOfElem = 0;
    public List<Entry> list;
    public List<Integer> indexList;

    public CustomTree() {
        this.root = new Entry<> ( "root" );
        list = new ArrayList<> ( );
        list.add ( root );
    }

    public boolean remove(Object o) {
        if (!(o instanceof String)) {
            throw new UnsupportedOperationException ();
        }
        int index = Integer.MIN_VALUE;
        String elementName = o.toString ();
        Entry entryToDelete = null;
        for (int i = 0; i < list.size (); i++) {
            if (list.get ( i ).elementName.equals ( elementName )) {
                entryToDelete = list.get ( i );
                index = i;
                break;
            }
        }

        List<Integer> childrenToDelete = findAllChildren ( entryToDelete );
        Collections.sort ( childrenToDelete, Collections.reverseOrder () );

        for (int i = 0; i < childrenToDelete.size (); i++) {
            list.remove ( (int) childrenToDelete.get ( i ) );
        }

        if (index != Integer.MIN_VALUE) {
            try {
                if (entryToDelete.elementName.equals ( entryToDelete.parent.leftChild.elementName )) {
                    entryToDelete.parent.availableToAddLeftChildren = true;
                    entryToDelete.parent.leftChild = null;
                } else if (entryToDelete.elementName.equals ( entryToDelete.parent.rightChild.elementName )) {
                    entryToDelete.parent.availableToAddRightChildren = true;
                    entryToDelete.parent.rightChild = null;
                }
            } catch (NullPointerException e) {
//                e.printStackTrace ();
            }
            list.remove ( index );
        }

        countOfElem = list.size ();
        return true;
    }

    public int getIndexInList(Entry entry) {
        int result = 0;
        for (int i = 0; i < list.size (); i++) {
            if (list.get ( i ).elementName.equals ( entry.elementName )) {
                result = i;
                break;
            }
        }
        return result;
    }

    public List<Integer> findAllChildren(Entry entry) {
        if (entry == null) {
            return new ArrayList (  );
        }
        indexList = new ArrayList<> (  );
        recur ( entry );
        return indexList;
    }


    public void recur(Entry entry) {
        if (!entry.availableToAddLeftChildren) {
            indexList.add ( getIndexInList ( entry.leftChild ) );
            recur ( entry.leftChild );
        }
        if (!entry.availableToAddRightChildren) {
            indexList.add ( getIndexInList ( entry.rightChild ) );
            recur ( entry.rightChild );
        }
    }

    public String getParent(String s) {
        String parentName = null;
        for (int i = 0; i < list.size (); i++) {
            if (!list.get ( i ).availableToAddLeftChildren) {
                if (list.get ( i ).leftChild.elementName.equals ( s )) {
                    parentName = list.get ( i ).elementName;
                }
            }
            if (!list.get ( i ).availableToAddRightChildren) {
                if(list.get ( i ).rightChild.elementName.equals ( s )) {
                    parentName = list.get ( i ).elementName;
                }
            }
        }
        return parentName;
    }

    @Override
    public boolean add(String elementName) {
        Entry current = new Entry( elementName );
        for (int i = 0; i < list.size (); i++) {
            if (list.get ( i ).isAvailableToAddChildren ()) {
                if (list.get ( i ).availableToAddLeftChildren) {
                    list.get ( i ).leftChild = current;
                    list.get ( i ).availableToAddLeftChildren = false;
                }else {
                    list.get ( i ).rightChild = current;
                    list.get ( i ).availableToAddRightChildren = false;
                }
                current.parent = list.get ( i );
                list.add ( current );
                countOfElem = list.size ();
                return true;
            }
        }
        return false;
    }

    public static class Entry<T> implements Serializable {
        String elementName;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            this.availableToAddLeftChildren = true;
            this.availableToAddRightChildren = true;
        }

        public boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren || availableToAddRightChildren;
        }
    }

    @Override
    public int size() {
        int count = 0;
        for (Entry entry : list) {
            count++;
        }
        return count - 1;
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }
}
