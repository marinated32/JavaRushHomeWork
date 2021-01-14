package com.javarush.task.task21.task2105;

import java.util.HashSet;
import java.util.Set;

/* 
Исправить ошибку. Сравнение объектов
*/

public class Solution {
    private final String first, last;
    private int hash;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;

        hash = 31;
        hash = 31 * hash + (first != null ? first.hashCode () : 0);
        hash = 31 * hash + (last != null ? last.hashCode () : 0);
    }

    @Override
    public int hashCode() {
        return hash;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Solution)) return false;

        Solution n = (Solution) o;

        if (this.hash != n.hash) return false;

        if (first != null ? !first.equals ( n.first ) : n.first != null) return false;
        if (last != null ? !last.equals ( n.last ) : n.last != null) return false;

        return true;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }
}
