static int[] BFS(int from) {
    int[] min_dis = new int[n + 1];
    Arrays.fill(min_dis, Integer.MAX_VALUE);
    min_dis[from] = 0;
    LinkedList<Integer> queue = new LinkedList<>();
    queue.addLast(from);
    while (!queue.isEmpty()) {
        int curr = queue.pollFirst();
        for (int e : adj[curr]) {
            if (min_dis[e] == Integer.MAX_VALUE) {
                min_dis[e] = 1 + min_dis[curr];
                queue.addLast(e);
            }
        }
    }
    return min_dis;
}