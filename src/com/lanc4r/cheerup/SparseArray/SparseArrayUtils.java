package com.lanc4r.cheerup.SparseArray;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 此类用于实现之前二维数组、稀疏数组的转换，并且支持稀疏数组持久化存储以及读取。<br>
 * 请参考云笔记上的那边文章<br>
 * 
 * 这里我理解我应该创建的是一个工具类，通过工具类来完成转换，我只提供方法
 */

public class SparseArrayUtils {

    // 普通数组转换为稀疏数组
    public static int[][] dataArr2SparseArr(int dataArr[][]) {

        // 首先根据二维数组初始化稀疏数组
        // 遍历二维数组，获取所有有效数据的集合。
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < dataArr.length; ++i) {
            for (int j = 0; j < dataArr[i].length; ++j) {
                if (dataArr[i][j] != 0) {
                    points.add(new Point(i, j, dataArr[i][j]));
                }
            }
        }

        // 根据有效数据开始构造稀疏数组
        // 稀疏第一行存储原始数组的 长、宽、有效元素个数
        int sparseArr[][] = new int[points.size() + 1][3];
        sparseArr[0][0] = dataArr.length;
        sparseArr[0][1] = dataArr[0].length;
        sparseArr[0][2] = points.size();

        for (int i = 1; i < sparseArr.length; ++i) {
            Point point = points.get(i - 1);
            for (int j = 0; j < 3; ++j) {
                if (j == 0) {
                    sparseArr[i][j] = point.getFirst();
                } else if (j == 1) {
                    sparseArr[i][j] = point.getSecond();
                } else {
                    sparseArr[i][j] = point.getValue();
                }
            }
        }
        return sparseArr;

    }

    // 稀疏数组转换为普通数组
    public static int[][] sparseArr2DataArr(int sparseArr[][]) {

        // 通过稀疏数组第一行的数据构造 二维数组的大小
        int dataArr[][] = new int[sparseArr[0][0]][sparseArr[0][1]];

        // 先初始化为 0
        for (int i = 0; i < dataArr.length; ++i) {
            for (int j = 0; j < dataArr[i].length; ++j) {
                dataArr[i][j] = 0;
            }
        }
        // 再遍历稀疏数组执行赋值
        for (int i = 1; i < sparseArr.length; ++i) {
            dataArr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        return dataArr;
    }

    // 存储稀疏数组
    public static void storeSparseArr(int sparseArr[][], String filePath) throws IOException {

        System.out.println("正在写入文件，请稍后....");

        // 打开文件进行读取
        File file = new File(filePath);
        FileWriter out = new FileWriter(file);

        // 遍历数组一每个数进行存入
        for (int i = 0; i < sparseArr.length; ++i) {
            for (int j = 0; j < sparseArr[i].length; ++j) {
                out.write(sparseArr[i][j] + "\t");
            }
            // 每一行读取完成之后加上换行标识
            out.write("\r\n");
        }

        System.out.println("写入成功!");

        out.close();
    }

    // 读取稀疏数组
    public static int[][] readSparseArr(String filePath) throws IOException {
        // 打开文件进行读取
        File file = new File(filePath);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line = null;
        int row = 0;

        // 先读取有多少行数据，进行数组的创建

        // 先标记文件流，方便后续复位
        in.mark((int) file.length() + 1);
        while (in.readLine() != null) {
            row++;
        }
        int sparseArr[][] = new int[row][3];

        // 再遍历每一行进行数据的赋值
        row = 0;
        in.reset();
        while ((line = in.readLine()) != null) {
            String[] values = line.split("\t");
            for (int i = 0; i < values.length; ++i) {
                sparseArr[row][i] = Integer.valueOf(values[i]);
            }
            row++;
        }

        in.close();
        return sparseArr;
    }
}

class Point {
    private int first;
    private int second;
    private int value;

    public Point(int first, int second, int value) {
        this.first = first;
        this.second = second;
        this.value = value;
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
