boolean[] reach(ArrayList<ArrayList<Integer>> g, int start, int ban) {
    int n = g.size();
    boolean[] visited = new boolean[n];
    ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
    queue.addLast(start);
    visited[start] = true;
    while (!queue.isEmpty()) {
        int v = queue.removeFirst();
        if (v == ban)
            continue;
        for (int to : g.get(v)) {
            if (!visited[to]) {
                visited[to] = true;
                queue.addLast(to);
            }
        }
    }
    return visited;
}