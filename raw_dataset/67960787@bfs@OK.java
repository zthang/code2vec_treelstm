static void bfs(Queue<Integer> q, ArrayList<Integer>[] g, int[] dis) {
    while (!q.isEmpty()) {
        int x = q.poll();
        for (int i : g[x]) {
            if (dis[i] == Integer.MAX_VALUE) {
                dis[i] = dis[x] + 1;
                q.add(i);
            }
        }
    }
}