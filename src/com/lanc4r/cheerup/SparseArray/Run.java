package com.lanc4r.cheerup.SparseArray;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Run {

    // 定义黑子和蓝子的坐标集合
    private static Map<Integer, Integer> blackMap = new HashMap<>();
    private static Map<Integer, Integer> blueMap = new HashMap<>();
    private static String filePath = "/Users/lanc4r/Home/program/Algorithm/学习笔记/稀疏数组/sparseArr.txt";

    static {
        // 初始化黑子的下标
        blackMap.put(1, 2);
        // 初始化蓝子的下标
        blueMap.put(2, 3);
    }

    public static void main(String[] args) throws IOException {
        // int dataArr[][] = new int[11][11];
        // initDataArr(dataArr);
        //
        // int[][] sparseArr = SparseArrayUtils.dataArr2SparseArr(dataArr);

        // int[][] dataArr2 = SparseArrayUtils.sparseArr2DataArr(sparseArr);
        // printArr(dataArr2);

        // SparseArrayUtils.storeSparseArr(sparseArr, filePath);
        int[][] readSparseArr = SparseArrayUtils.readSparseArr(filePath);
        printArr(readSparseArr);
    }

    // 初始化
    public static void initDataArr(int[][] dataArr) {
        // 初始化稀疏数组,使用 1 表示黑子，2 表示蓝子
        for (int i = 0; i < 11; ++i) {
            for (int j = 0; j < 11; ++j) {
                // 先简答判断，这里其实可以抽取一个方法
                if (Integer.valueOf(j).equals(blackMap.get(i))) {
                    dataArr[i][j] = 1;
                } else if (Integer.valueOf(j).equals(blueMap.get(i))) {
                    dataArr[i][j] = 2;
                } else {
                    dataArr[i][j] = 0;
                }
            }
        }
    }

    public static void printArr(int dataArr[][]) {
        for (int i = 0; i < dataArr.length; ++i) {
            for (int j = 0; j < dataArr[i].length; ++j) {
                System.out.print(dataArr[i][j] + "\t");
            }
            System.out.println();
        }
    }

}
