package com.test.corejava;
//3 steps
//Singleton class - Only once instance can be created at any given time.
public class SingletonClass {

    //1. static variable - same class instance in memory
    private static SingletonClass single_instance = null;

    //2. Constructor private - nobody can create its object
    private SingletonClass() {
    }

    //3. Static method - to initialize single object
    public static SingletonClass getInstance(){
        if(single_instance == null){
            single_instance = new SingletonClass();
        }
        return single_instance;
    }
}
