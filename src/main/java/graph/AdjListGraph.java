package graph;

import java.util.*;

/**
 * 邻接表表示的有向图
 */
public class AdjListGraph {
    /**
     * 构造顶点结构
     */
    static class Vertex {
        public String name;
        public boolean isVisible;

        public Vertex(String name) {
            this.name = name;
        }
    }

    //图的所有顶点
    private Set<Vertex> vertexSet = new HashSet<>();

    //相邻结点
    private Map<Vertex, List<Vertex>> adjVertexMap = new HashMap<>();

    public Set<Vertex> getVertexSet() {
        return vertexSet;
    }

    public Map<Vertex, List<Vertex>> getAdjVertexMap() {
        return adjVertexMap;
    }

    /**
     * 构造有向图结构
     *
     * @return 返回图的假定起点
     */
    public Vertex init() {
        Vertex vertex0 = new Vertex("V0");
        Vertex vertex1 = new Vertex("V1");
        Vertex vertex2 = new Vertex("V2");
        Vertex vertex3 = new Vertex("V3");
        Vertex vertex4 = new Vertex("V4");
        Vertex vertex5 = new Vertex("V5");
        Vertex vertex6 = new Vertex("V6");
        Vertex vertex7 = new Vertex("V7");

        vertexSet.add(vertex0);
        vertexSet.add(vertex1);
        vertexSet.add(vertex2);
        vertexSet.add(vertex3);
        vertexSet.add(vertex4);
        vertexSet.add(vertex5);
        vertexSet.add(vertex6);
        vertexSet.add(vertex7);


        LinkedList<Vertex> linkedList0 = new LinkedList<>();
        linkedList0.add(vertex1);
        linkedList0.add(vertex2);

        LinkedList<Vertex> linkedList1 = new LinkedList<>();
        linkedList1.add(vertex3);
        linkedList1.add(vertex4);

        LinkedList<Vertex> linkedList2 = new LinkedList<>();
        linkedList2.add(vertex5);
        linkedList2.add(vertex6);

        LinkedList<Vertex> linkedList3 = new LinkedList<>();
        linkedList3.add(vertex7);

        LinkedList<Vertex> linkedList4 = new LinkedList<>();
        linkedList4.add(vertex7);

        LinkedList<Vertex> linkedList5 = new LinkedList<>();
        linkedList5.add(vertex6);

        adjVertexMap.put(vertex0, linkedList0);
        adjVertexMap.put(vertex1, linkedList1);
        adjVertexMap.put(vertex2, linkedList2);
        adjVertexMap.put(vertex3, linkedList3);
        adjVertexMap.put(vertex4, linkedList4);
        adjVertexMap.put(vertex5, linkedList5);

        for (Vertex vertex : vertexSet) {
            if (adjVertexMap.containsKey(vertex)) {
                List<Vertex> list = adjVertexMap.get(vertex);
                if (!list.isEmpty()) {
                    System.out.print("顶点 " + vertex.name + "的边有: ");
                    for (Vertex vertexNext : list) {
                        System.out.print(vertex.name + " -> " + vertexNext.name + " ");
                    }
                    System.out.println();
                }
            }
        }

        return vertex0;
    }

    public Vertex init_1() {
        Vertex vertex0 = new Vertex("V0");
        Vertex vertex1 = new Vertex("V1");
        Vertex vertex2 = new Vertex("V2");
        Vertex vertex3 = new Vertex("V3");
        Vertex vertex4 = new Vertex("V4");
        Vertex vertex5 = new Vertex("V5");
        Vertex vertex6 = new Vertex("V6");
        //Vertex vertex7 = new Vertex("V7");

        vertexSet.add(vertex0);
        vertexSet.add(vertex1);
        vertexSet.add(vertex2);
        vertexSet.add(vertex3);
        vertexSet.add(vertex4);
        vertexSet.add(vertex5);
        vertexSet.add(vertex6);
        //vertexSet.add(vertex7);


        LinkedList<Vertex> linkedList0 = new LinkedList<>();
        linkedList0.add(vertex1);

        LinkedList<Vertex> linkedList1 = new LinkedList<>();
        linkedList1.add(vertex2);
        linkedList1.add(vertex5);

        LinkedList<Vertex> linkedList2 = new LinkedList<>();
        linkedList2.add(vertex4);

        LinkedList<Vertex> linkedList3 = new LinkedList<>();
        linkedList3.add(vertex2);

        LinkedList<Vertex> linkedList4 = new LinkedList<>();
        linkedList4.add(vertex3);

        LinkedList<Vertex> linkedList5 = new LinkedList<>();
        linkedList5.add(vertex6);

        adjVertexMap.put(vertex0, linkedList0);
        adjVertexMap.put(vertex1, linkedList1);
        adjVertexMap.put(vertex2, linkedList2);
        adjVertexMap.put(vertex3, linkedList3);
        adjVertexMap.put(vertex4, linkedList4);
        adjVertexMap.put(vertex5, linkedList5);

        for (Vertex vertex : vertexSet) {
            if (adjVertexMap.containsKey(vertex)) {
                List<Vertex> list = adjVertexMap.get(vertex);
                if (!list.isEmpty()) {
                    System.out.print("顶点 " + vertex.name + "的边有: ");
                    for (Vertex vertexNext : list) {
                        System.out.print(vertex.name + " -> " + vertexNext.name + " ");
                    }
                    System.out.println();
                }
            }
        }

        return vertex0;
    }

    public void dfs(Vertex vertex) {
        Map<Vertex, List<Vertex>> map = adjVertexMap;
        List<Vertex> list = map.get(vertex);

        System.out.print(vertex.name + " ");
        vertex.isVisible = true;
        if (list != null && !list.isEmpty()) {
            for (Vertex v : list) {
                if (!v.isVisible) {
                    dfs(v);
                }
            }
        }
    }

    public void bfs(Vertex vertex) {
        Map<Vertex, List<Vertex>> map = adjVertexMap;
        Queue<Vertex> queue = new LinkedList<>();
        queue.offer(vertex);
        vertex.isVisible = true;

        while (!queue.isEmpty()) {
            Vertex v = queue.poll();
            System.out.print(v.name + " ");
            List<Vertex> list = map.get(v);
            if (list != null && !list.isEmpty()) {
                for (Vertex e : list) {
                    if (!e.isVisible) {
                        queue.offer(e);
                        e.isVisible = true;
                    }
                }
            }
        }
    }

    public void initVisible() {
        for (Vertex vertex : vertexSet) {
            vertex.isVisible = false;
        }
    }

    public static void main(String[] args) {
        AdjListGraph graph = new AdjListGraph();
        Vertex vertex = graph.init_1();

        graph.dfs(vertex);

        System.out.println();

        graph.initVisible();
        graph.bfs(vertex);
    }
}
