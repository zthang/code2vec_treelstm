public static void printMinAndMaxRebuilds(ArrayList<ArrayList<Integer>> graph, ArrayList<ArrayList<Integer>> invertedGraph, int[] path) {
    int n = path.length;
    int V = graph.size() - 1;
    int[] minPathLength = new int[V + 1];
    boolean[] visited = new boolean[V + 1];
    int source = path[0];
    int destination = path[n - 1];
    bfs(invertedGraph, visited, source, destination, minPathLength);
    int minRebuilds = 0, maxRebuilds = 0;
    for (int i = 0; i < n - 1; i++) {
        if (minPathLength[path[i]] < minPathLength[path[i + 1]] + 1) {
            minRebuilds++;
            maxRebuilds++;
        } else {
            for (int j = 0; j < graph.get(path[i]).size(); j++) {
                if (graph.get(path[i]).get(j) != path[i + 1] && minPathLength[graph.get(path[i]).get(j)] + 1 == minPathLength[path[i]]) {
                    maxRebuilds++;
                    break;
                }
            }
        }
    }
    System.out.println(minRebuilds + " " + maxRebuilds);
}