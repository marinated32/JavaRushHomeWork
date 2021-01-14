package com.javarush.task.task21.task2104;

import java.io.ObjectInputStream;
import java.util.HashSet;
import java.util.Set;

/* 
Equals and HashCode
*/

public class Solution {
    private final String first, last;
    private int hash;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;

        hash = 31 + (first != null ? first.hashCode () : 0);
        hash = 31 * hash + (last != null ? last.hashCode () : 0);
    }

    public boolean equals(Object n) {
        if (this == n) return true;
        if (!(n instanceof Solution)) return false;
        if (n == null) return false;

        Solution o = (Solution) n;

        if (hash != o.hash) return false;

        if (first != null ? !first.equals ( o.first ) : o.first != null) return false;
        if (last != null ? !last.equals ( o.last ) : o.last != null) return false;

        return true;
    }

    public int hashCode() {
        return hash;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }
}
