package com.lanc4r.cheerup.Queue;

/**
 * 数组模拟循环队列，你可以理解为一个环形的队列啦<br>
 * 下面说说两个简单的实现思路<br>
 * 1.通过增加当前队列内数值标记，队列为空 或者 队列已满 两种状态通过这个标记来判断<br>
 * 2.通过队首和队尾指针来判断对 队列为空 或 队列已满的情况
 */

public class CircularQueue {

    // 定义一个数组来存放队列内的数据
    private int queue[];
    // 定义队头和队尾指针 —— 其实就是记录的下标值啦
    private int start;
    private int end;
    // 定义当前数组的长度
    private int len;

    public CircularQueue(int capacity) {
        init(capacity);
    }

    private void init(int capacity) {
        queue = new int[capacity];
        start = end = 0;
        len = queue.length;
    }

    /**
     * 判断队列是否已满<br>
     * 
     * 当队首和队尾指针指向同一处，并且队首指定值不为默认值0
     */
    private boolean isFull() {
        return start == end && queue[start] != 0;
    }

    /**
     * 判断队列是否为空<br>
     * 
     * 当队首和队尾指针指向同一处，并且队首指定值为默认值 0
     */
    private boolean isEmpty() {
        return start == end && queue[start] == 0;
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

        queue[end++] = val;
        end = end % len;
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
        // 移除后将指定的值设置为 0
        queue[start++] = 0;
        start = start % len;
        return result;
    }

    // 打印队列数据
    public void printQueue() {
        if (!isEmpty()) {
            // 打印区分队列是否已满的情况
            if (!isFull()) {
                while (start != end) {
                    int val = queue[start++];
                    start = start % len;
                    System.out.print(val + "  ");
                }
            } else {
                int flag = len;
                while (flag-- > 0) {
                    int val = queue[start++];
                    start = start % len;
                    System.out.print(val + "  ");
                }
            }
        }
    }
}
