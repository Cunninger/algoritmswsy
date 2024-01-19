package algoritmsbasic2020;


import java.util.*;

public class Code01_Graph {
    public static class Node {
        public int value;
        public int in;
        public int out;
        public List<Node> nexts;
        public List<Edge> edges;

        public Node(int v) {
            value = v;
            in = 0;
            out = 0;
            nexts = new ArrayList<>();
            edges = new ArrayList<>();

        }
    }

    public static class Edge {
        public int weight;
        public Node from;
        public Node to;


        public Edge(int w, Node f, Node t) {
            weight = w;
            from = f;
            to = t;
        }
    }


    public static class Graph {

        public HashMap<Integer, Node> nodes;
        public HashSet<Edge> edges;

        public Graph() {
            nodes = new HashMap<>();
            edges = new HashSet<>();
        }


    }

    public static Graph createGraph(int [][] matrix) {
        Graph graph = new Graph();
        // [ _ _ _ ] 权值，fromNode ，toNode
        for (var m : matrix) {
            int weight = m[0];
            int from = m[1];
            int to = m[2];

            if (!graph.nodes.containsKey(from)) {
                graph.nodes.put(from, new Node(from));

            }
            if (!graph.nodes.containsKey(to)) {
                graph.nodes.put(to, new Node(to));
            }
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);

            Edge edge = new Edge(weight, fromNode, toNode);
            fromNode.nexts.add(toNode);
            fromNode.out++;
            toNode.in++;
            fromNode.edges.add(edge);

            graph.edges.add(edge);

        }
        return graph;
    }


    public static void bfs(Node node) {
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();

        queue.add(node);
        set.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.print(cur.value+" ");
            for (var i : cur.nexts) {
                if (!set.contains(i)) {
                    set.add(i);
                    queue.add(i);
                }
            }
        }
    }

    public static void dfs(Node node){
        Stack<Node> stack =  new Stack<>();
        HashSet<Node> set = new HashSet<>();
        stack.push(node);
        set.add(node);
        System.out.print(node.value+" ");

        while (!stack.isEmpty()){
            Node cur = stack.pop();
            for (var i :cur.nexts){
                if (!set.contains(i)){
                     set.add(i);
                    stack.push(cur);
                    stack.push(i);
                    System.out.print(i.value+" ");
                    break;
                }
            }
        }

    }
    public static List<Integer> TopuSort(Graph graph){
        Queue<Node> zeroInQueue = new LinkedList<>();
        HashMap<Node,Integer> inMap = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for (var node:graph.nodes.values()){
                inMap.put(node,node.in);
                if (node.in==0){
                    zeroInQueue.add(node);
                }
        }

        while (!zeroInQueue.isEmpty()){
            Node cur = zeroInQueue.poll();
            ans.add(cur.value);
            for (var i:cur.nexts){
                inMap.put(i,inMap.get(i)-1);
                if (inMap.get(i)==0){
                    zeroInQueue.add(i);
                }
            }
        }
        return  ans;
    }


    public static void main(String[] args) {
        int[][] matrix = {{1,1,2},{1,1,3},{1,2,4},{1,3,4},{1,4,5}};

        Graph graph = createGraph(matrix);

        HashMap<Integer, Node> nodes = graph.nodes;
        HashSet<Edge> edges = graph.edges;



//        bfs(nodes.get(5));
//        System.out.println();
//        dfs(nodes.get(5));
        List<Integer> ans =  TopuSort(graph);

        for (Integer an : ans) {
            System.out.print(an+" ");
        }
    }


}
