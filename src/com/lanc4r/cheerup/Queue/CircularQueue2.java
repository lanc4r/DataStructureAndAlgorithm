package com.lanc4r.cheerup.Queue;

/**
 * 数组模拟循环队列，你可以理解为一个环形的队列啦<br>
 * 下面说说实现思路，与关键点:<br>
 * 1. 首先需要留一个位置不能全部用来存储数据<br>
 * 2. 还需要一个标记用来存储已存储的数据<br>
 * 3. 为了能够循环存储，再存储的时候需要计算出存储的位置，不能再是简单的加一了<br>
 * 4. 判空 和 判满的条件需要根据存储已放数据的个数来决定。
 */

public class CircularQueue2 {

    // 定义一个数组来存放队列内的数据
    private int queue[];
    // 定义队头和队尾指针 —— 其实就是记录的下标值啦
    private int start;
    private int end;
    // 定义当前队列已经存储的个数，需要通过这个标记来辅助完成判空和判满的操作
    private int count;
    // 定义当前数组的长度
    private int len;

    public CircularQueue2(int capacity) {
        init(capacity);
    }

    private void init(int capacity) {
        queue = new int[capacity];
        start = end = count = 0;
        len = queue.length;
    }

    /**
     * 判断队列是否已满<br>
     * 
     * 数组最大容量表示队列已满
     */
    private boolean isFull() {
        return count == len;
    }

    /**
     * 判断队列是否为空<br>
     * 
     * count 为 0 的时候表示队列为空
     */
    private boolean isEmpty() {
        return count == 0;
    }

    /**
     * 加入队列操作<br>
     * 
     * 和之前非循环队列不同，新增数值不单单是队尾指针 +1 这么简单<br>
     * 1. 当队尾指针还未到数组长度时候，直接加一即可<br>
     * 2. 当队尾指针已经到达数组长度时候，需要想办法让其又从 0 开始。<br>
     * 3. 想个公式能够中和一下 1 和 2 两点
     */
    public void add(int val) {
        if (isFull()) {
            System.out.println("增加失败，当前队列内容已满~");
            return;
        }

        queue[end] = val;
        end = (end + 1) % len;
        count++;
    }

    /**
     * 移除队列操作<br>
     * 
     * 和之前非循环队列不同，移除数值不单单是队首指针 +1 这么简单<br>
     * 1. 当队首指针还未到数组长度时候，直接加一即可<br>
     * 2. 当队首指针已经到达数组长度时候，需要想办法让其又从 0 开始。<br>
     * 3. 想个公式能够中和一下 1 和 2 两点
     */
    public int remove() {
        if (isEmpty()) {
            System.out.println("出栈失败，当前栈内数据为空~");
            return -1;
        }

        int result = queue[start];
        start = (start + 1) % len;
        count--;
        return result;
    }

    // 打印队列数据
    public void printQueue() {
        while (count-- > 0) {
            int val = queue[start];
            start = (start + 1) % len;
            System.out.print(val + "  ");
        }
    }
}
