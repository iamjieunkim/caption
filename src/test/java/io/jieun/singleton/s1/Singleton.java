package io.jieun.singleton.s1;

public class Singleton {

    private static Singleton instance;

    private Singleton() {

    }

    public static Singleton getInstance() {
        System.out.println("S1SingletonTest.test");
        if (instance == null) {
            System.out.println(Thread.currentThread().getName() + "인스턴스생성!");
            instance = new Singleton();
        }

        return instance;
    }
}
