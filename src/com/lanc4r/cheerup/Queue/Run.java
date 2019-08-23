package com.lanc4r.cheerup.Queue;

public class Run {

    public static void main(String[] args) {
        testCircularQueue();
    }

    // 测试循环队列
    public static void testCircularQueue() {

        CircularQueue queue = new CircularQueue(10);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        queue.add(7);
        queue.add(8);
        queue.add(9);
        queue.add(10);
        // printArr(queue.getQueue());
        // queue.add(11);

        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());

        queue.add(11);
        queue.add(12);
        System.out.println(queue.remove());
        queue.add(13);
        queue.add(14);

        queue.printQueue();
    }

    // 测试非循环队列
    public static void testQueue() {
        // 测试
        Queue queue = new Queue(10);

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        queue.add(7);
        queue.add(8);
        queue.add(9);
        queue.add(10);

        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
    }

}
