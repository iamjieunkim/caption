package io.jieun.singleton.s0;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class S0SingletonTest {

    @Test
    @DisplayName("가장 간단히 싱글톤을 구현하는 방법 테스트")
    void simple_singleton_test() throws Exception {

        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();

        System.out.println("instance1 = " + instance1);
        System.out.println("instance2 = " + instance2);

        //2개 같은 값이 나옴
        //instance1 = io.jieun.singleton.s0.Singleton@169bb4dd
        //instance2 = io.jieun.singleton.s0.Singleton@169bb4dd

    }

    @Test
    @DisplayName("쓰레드 안전한 방식인지 테스트")
    void simple_singleton_thread_test() throws Exception {

        Runnable task = () -> {
            Singleton instance = Singleton.getInstance();
            System.out.println(Thread.currentThread().getName() + " - " + instance);
        };

        new Thread(task, "Thread 1");
        new Thread(task, "Thread 2");

    }
}
