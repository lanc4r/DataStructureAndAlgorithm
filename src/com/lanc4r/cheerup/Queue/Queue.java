package com.lanc4r.cheerup.Queue;

/**
 * 使用数组模拟队列情况：这是一个不循环队列，空间使用完毕之后就没有了，就必须初始化
 */

public class Queue {

    // 定义一个数组来存放队列内的数据
    private int queue[];
    // 定义队头和队尾指针 —— 其实就是记录的下标值啦
    private int start;
    private int end;

    public Queue(int capacity) {
        init(capacity);
    }

    private void init(int capacity) {
        queue = new int[capacity];
        start = end = 0;
    }

    // 加入队列操作
    public void add(int val) {
        // 判断队列是否已满: 当队头指针和队列长度相等时候表示队列已满
        if (start == queue.length) {
            System.out.println("增加失败，当前队列内容已满~");
            return;
        }
        queue[start++] = val;
        System.out.println("增加成功, val=" + val);
    }

    // 移除队列操作
    public int remove() {
        // 判断当前队列内是否存在有效值:如果队头指针和队尾指针重合表示当前队列内不存在值
        if (end == start) {
            System.out.println("出栈失败，当前栈内数据为空~");
            return -1;
        }
        return queue[end++];
    }

    // 定义一个方法来返回队列数据，方便打印查看
    public int[] getQueue() {
        return queue;
    }

}
