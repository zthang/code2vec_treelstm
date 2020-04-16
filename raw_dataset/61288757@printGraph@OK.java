static void printGraph(Graph graph) {
    for (int v = 0; v < graph.V; v++) {
        System.out.println("Adjacency list of vertex " + v);
        System.out.print("head");
        for (Integer pCrawl : graph.adjListArray[v]) {
            System.out.print(" -> " + pCrawl);
        }
        System.out.println("\n");
    }
}