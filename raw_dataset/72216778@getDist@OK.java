public static void getDist(int s) {
    Arrays.fill(dist, (int) 1e9);
    dist[s] = 0;
    Queue<Integer> q = new LinkedList<Integer>();
    q.add(s);
    while (!q.isEmpty()) {
        int cur = q.poll();
        for (int x : revadjList[cur]) {
            if (dist[x] == (int) 1e9) {
                dist[x] = dist[cur] + 1;
                q.add(x);
            }
        }
    }
}