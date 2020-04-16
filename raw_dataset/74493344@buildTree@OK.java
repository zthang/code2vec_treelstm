private static int buildTree(Map<Integer, Vertex> intToVertex, Map<Integer, List<Integer>> graph, int time, Vertex v) {
    v.timeIn = time + 1;
    time++;
    for (int i = 0; i < graph.get(v.n).size(); i++) {
        if (!intToVertex.containsKey(graph.get(v.n).get(i))) {
            Vertex u = new Vertex(graph.get(v.n).get(i));
            u.parent = v;
            intToVertex.put(u.n, u);
            time = buildTree(intToVertex, graph, time, u);
        }
    }
    v.tineOut = time + 1;
    return time + 1;
}