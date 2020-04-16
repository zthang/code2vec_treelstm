public void bfs(int x) {
    Queue<Integer> qu = new ArrayDeque<Integer>();
    visit[x] = 1;
    cost[x] = 0;
    qu.add(x);
    while (!qu.isEmpty()) {
        x = qu.poll();
        for (int y : adj1[x]) {
            if (visit[y] == 0) {
                visit[y] = 1;
                cost[y] = cost[x] + 1;
                qu.add(y);
            }
        }
    }
}