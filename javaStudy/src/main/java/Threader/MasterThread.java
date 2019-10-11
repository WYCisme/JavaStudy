package Threader;


import org.junit.Test;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @projectName: javaStudy
 * @className: MasterThread
 * @author: WenYichong
 * @date: 2019/8/4-21:57
 * @description: 连我自己都不知道在写什么......
 */
public class MasterThread extends Thread {

            //非阻塞式队列 无界(可以声明无限个队列)
    @Test
    public static void test1() {

        ConcurrentLinkedDeque<Object> objects = new ConcurrentLinkedDeque<>();
        objects.offer("java001");
        objects.offer("java002");

        System.out.println("队列总数：" + objects.size());
        //建议：获取队列之后删除
        System.out.println("获取队列但不删除：" + objects.peek());
        System.out.println("获取队列但不删除,队列总数：" + objects.size());
        System.out.println("获取队列删除：" + objects.poll());

        //非阻塞式队列，如果为空返回null
        System.out.println(objects.poll());
        System.out.println(objects.poll());
        System.out.println(objects.poll());
        System.out.println("获取队列删除,队列总数：" + objects.size());
    }
}
