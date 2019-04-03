package graph;

import java.util.*;

/**
 * 带权值的有向图邻接矩阵
 */
public class AdjMatrixGraph {
    private int size; //顶点个数
    private int[][] matrix; //邻接矩阵，存储边的信息
    private int numOfEdges; //边的个数

    public AdjMatrixGraph(int size) {
        this.size = size;
        matrix = new int[size][size];
    }

    /**
     * 插入结点之间的边
     *
     * @param v1     边的起点位置
     * @param v2     边的终点位置
     * @param weight 权值
     */
    public void insertEdge(int v1, int v2, int weight) {
        matrix[v1][v2] = weight;
        numOfEdges++;
    }

    public void print() {
        for (int[] m : matrix) {
            System.out.println(Arrays.toString(m));
        }
    }

    /**
     * 递归实现
     */
    public void dfs() {
        boolean[] visited = new boolean[size]; //访问标志
        for (int i = 0; i < size; i++) {
            if (!visited[i]) {
                dfsHelper(visited, i);
            }
        }
    }

    private void dfsHelper(boolean[] visited, int i) {
        visited[i] = true;
        System.out.print(i + " ");
        for (int j = 0; j < size; j++) {
            if (!visited[j] && matrix[i][j] > 0) {
                dfsHelper(visited, j);
            }
        }
    }

    /**
     * 非递归实现
     */
    public void dfsNonRecursive() {
        boolean[] visited = new boolean[size]; //访问标志
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < size; i++) {
            if (!visited[i]) {
                visited[i] = true;
                System.out.print(i + " ");
                stack.push(i);
            }
            while (!stack.isEmpty()) {
                int k = stack.pop();
                for (int j = 0; j < size; j++) {
                    if (matrix[k][j] > 0 && !visited[j]) {
                        visited[j] = true;
                        System.out.print(j + " ");
                        stack.push(j);
                        break;
                    }
                }
            }
        }
    }

    /**
     * 广度优先遍历
     */
    public void bfs() {
        boolean[] visited = new boolean[size];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            if (!visited[i]) {
                visited[i] = true;
                System.out.print(i + " ");
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int k = queue.poll();
                    for (int j = 0; j < size; j++) {
                        if (matrix[k][j] > 0 && !visited[j]) {
                            visited[j] = true;
                            System.out.print(j + " ");
                            queue.offer(j);
                        }
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        int size = 7;
        AdjMatrixGraph graph = new AdjMatrixGraph(size);
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(2, 4, 1);
        graph.insertEdge(4, 3, 1);
        graph.insertEdge(3, 2, 1);
        //graph.insertEdge(1, 4, 1);
        //graph.insertEdge(4, 1, 1);
        graph.insertEdge(1, 5, 1);
        graph.insertEdge(5, 6, 1);

        graph.print();
        graph.dfs();
        System.out.println();
        graph.dfsNonRecursive();
        System.out.println();
        graph.bfs();
    }
}
