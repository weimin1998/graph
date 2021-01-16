package com.weimin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Graph<T> {

    // 顶点的集合
    private List<T> nodes;

    // 邻接矩阵
    private int[][] edgs;

    // 边的数目
    private int numOfEdges;

    // 顶点是否被遍历
    private boolean[] isVisited;


    /**
     * @param n 顶点的个数
     */
    public Graph(int n) {
        nodes = new ArrayList<>(n);
        edgs = new int[n][n];
        isVisited = new boolean[n];
    }

    // 插入顶点
    public void addNode(T data) {
        nodes.add(data);
    }

    // 插入边
    public void addEdges(int v1, int v2, int weight) {
        edgs[v1][v2] = weight;
        edgs[v2][v1] = weight;
        numOfEdges++;
    }

    // 显示这个图的邻接矩阵
    public void show() {
        for (int[] edg : edgs) {
            System.out.println(Arrays.toString(edg));
        }
    }


    /******************************************************/

    // 得到第一个邻接顶点的下标
    public int getFirstNeighbor(int index) {
        for (int i = 0; i < nodes.size(); i++) {
            if (edgs[index][i] == 1) {
                return i;
            }
        }
        return -1;
    }

    // 根据前一个邻接顶点的下标，获取下一个邻接顶点的下标
    public int getNextNeighbor(int index, int firstNeighbor) {
        for (int i = firstNeighbor + 1; i < nodes.size(); i++) {
            if (edgs[index][i] == 1) {
                return i;
            }
        }
        return -1;
    }

    // 深度优先遍历
    public void dfs() {
        for (int i = 0; i < nodes.size(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }

    // 对一个顶点进行深度优先
    private void dfs(boolean[] isVisited, int i) {
        // 遍历
        T t = nodes.get(i);
        System.out.println(t);

        //设置为已经遍历
        isVisited[i] = true;

        //
        int firstNeighbor = getFirstNeighbor(i);
        while (firstNeighbor != -1) {
            // 还没访问过
            if (!isVisited[firstNeighbor]) {
                dfs(isVisited, firstNeighbor);
            }
            // 已经访问过
            firstNeighbor = getNextNeighbor(i, firstNeighbor);
        }

    }

    // 广度优先
    public void bfs() {
        for (int i = 0; i < nodes.size(); i++) {
            if (!isVisited[i]) {
                bfs(isVisited, i);
            }
        }
    }

    private void bfs(boolean[] isVisited, int i) {

        int u;
        int w;
        LinkedList<Integer> queue = new LinkedList<>();

        // 遍历
        T t = nodes.get(i);
        System.out.println(t);

        //设置为已经遍历
        isVisited[i] = true;

        queue.addLast(i);

        while (!queue.isEmpty()) {
            u = queue.removeFirst();

            w = getFirstNeighbor(u);

            while (w != -1) {
                if (!isVisited[w]) {
                    T t1 = nodes.get(w);
                    System.out.println(t1);
                    isVisited[w] = true;
                    queue.addLast(w);
                }
                w = getNextNeighbor(u, w);
            }
        }

    }

    public static void main(String[] args) {

    }
}
