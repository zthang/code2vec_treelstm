static void bfs(ArrayList<Integer> start, ArrayList<Integer> end) {
    int[] d = new int[V];
    Arrays.fill(d, Integer.MAX_VALUE);
    Queue<Integer> q = new LinkedList<>();
    for (Integer i : start) {
        d[i] = 0;
        q.add(i);
    }
    while (!q.isEmpty()) {
        int v = q.poll();
        for (Integer x : graph[v]) {
            if (d[x] == Integer.MAX_VALUE) {
                d[x] = d[v] + 1;
                q.add(x);
            }
        }
    }
    for (Integer i : end) if (d[i] != Integer.MAX_VALUE)
        ans[i] = d[i];
}