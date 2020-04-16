static int[] bfs(ArrayList<Integer>[] adj, int source, int n) {
    int[] distS = new int[n];
    Arrays.fill(distS, 2 * n);
    distS[source] = 0;
    ArrayDeque<Integer> q = new ArrayDeque<>();
    q.add(source);
    while (!q.isEmpty()) {
        int next = q.poll();
        for (int e : adj[next]) {
            if (distS[e] != 2 * n)
                continue;
            distS[e] = distS[next] + 1;
            q.add(e);
        }
    }
    return distS;
}