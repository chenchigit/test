package com.test;

class RunnableTest implements Runnable{
    int i;
    public void run() {
        for (i = 1; i<=10; i++) {
            System.out.println(Thread.currentThread().getName() + "这个线程正在运行 ！");
        }
    }
}

public class test_thread {

    public static void main(String[] args) {
        RunnableTest rt = new RunnableTest();
        Thread tr1 = new Thread(rt);
        tr1.start();
        Thread tr2 = new Thread(rt); // 如果创建多个线程基于同一个Runnable target，即rt则所有线程共同执行其中的资源。
        tr2.start();

    }

}
