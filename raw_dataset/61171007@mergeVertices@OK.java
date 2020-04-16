Graph mergeVertices(int a, int b) {
    Graph graph = new Graph(7);
    for (int i = 1; i <= 7; i++) {
        if (i != b) {
            for (int j = 0; j < edge[i].size(); j++) {
                int c = edge[i].get(j);
                if (c == b) {
                    if (!graph.edge[i].contains(a)) {
                        graph.addEdge(i, a);
                    }
                } else {
                    if (!graph.edge[i].contains(c)) {
                        graph.addEdge(i, c);
                    }
                }
            }
        }
    }
    // System.out.println("ssssssss"            );
    return graph;
}