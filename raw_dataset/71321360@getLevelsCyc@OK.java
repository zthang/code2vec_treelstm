public static boolean[] getLevelsCyc(int[] levels, int[] parent, ArrayList<ArrayList<Integer>> connections, int root) {
    ArrayList<Integer> nodes = new ArrayList<>();
    nodes.add(root);
    boolean[] visited = new boolean[connections.size()];
    visited[root] = true;
    for (int currentLevel = 0; !nodes.isEmpty(); currentLevel++) {
        ArrayList<Integer> futureNodes = new ArrayList<>();
        for (int x : nodes) {
            levels[x] = currentLevel;
            for (int node : connections.get(x)) {
                if (!visited[node]) {
                    futureNodes.add(node);
                    parent[node] = x;
                    visited[node] = true;
                }
            }
        }
        nodes = futureNodes;
    }
    return visited;
}