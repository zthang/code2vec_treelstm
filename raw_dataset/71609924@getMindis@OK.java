static int[] getMindis(int node) {
    boolean[] visited = new boolean[n];
    Arrays.fill(visited, false);
    int[] mindis = new int[n];
    mindis[node] = 0;
    visited[node] = true;
    Queue<NodeDis> queue = new ArrayDeque<>();
    queue.add(new NodeDis(node, 0));
    while (queue.size() > 0) {
        NodeDis top = queue.poll();
        for (int i = 0; i < graph[top.node].size(); i++) {
            int neigh = (int) graph[top.node].get(i);
            if (visited[neigh])
                continue;
            visited[neigh] = true;
            mindis[neigh] = top.dis + 1;
            queue.add(new NodeDis(neigh, top.dis + 1));
        }
    }
    return mindis;
}