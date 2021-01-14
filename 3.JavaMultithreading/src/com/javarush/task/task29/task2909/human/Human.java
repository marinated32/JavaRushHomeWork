package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Human implements Alive {
    private static int nextId = 0;
    private int id;
    protected int age;
    protected String name;
    private List<Human> children = new ArrayList<>();

    protected Size size;

    private BloodGroup bloodGroup;

    public class Size {
        public int height;
        public int weight;
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public Human(String name, int age) {
//        this.isSoldier = isSoldier;
        this.name = name;
        this.age = age;
        this.id = nextId;
        nextId++;
    }

    public String getPosition() {return "Человек";}

    public void printData() {
        System.out.println(getPosition () + ": " + name);
    }

    public List<Human> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public void addChild(Human human) {
        children.add ( human );
    }

    public void removeChild(Human human) {
        children.remove ( human );
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public int getCourse() {
//        return course;
//    }

    public void live() {
//        if (this instanceof Worker)
//            fight();
    }

//    public void fight() {
//    }

    public int getId() {
        return id;
    }

    public void printSize() {
        System.out.println("Рост: " + size.height + " Вес: " + size.weight);
    }
}