public static void bfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int source, int destination, int[] minPathLength) {
    Queue<Integer> pendingNodes = new LinkedList<>();
    pendingNodes.add(destination);
    visited[destination] = true;
    int level = 0;
    int count = 1;
    while (pendingNodes.isEmpty() == false) {
        int front = pendingNodes.remove();
        minPathLength[front] = level;
        for (int i = 0; i < graph.get(front).size(); i++) {
            if (visited[graph.get(front).get(i)] == false) {
                visited[graph.get(front).get(i)] = true;
                pendingNodes.add(graph.get(front).get(i));
            }
        }
        count--;
        if (count == 0) {
            level++;
            count = pendingNodes.size();
        }
    }
}