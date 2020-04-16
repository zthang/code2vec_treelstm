static int[] BFS(int n, HashSet<Integer> sources, ArrayList<Integer>[] adj) {
    int[] min_dis = new int[n];
    Arrays.fill(min_dis, -1);
    LinkedList<Integer> queue = new LinkedList<>();
    for (int e : sources) {
        queue.addLast(e);
        min_dis[e] = 1;
    }
    while (!queue.isEmpty()) {
        int curr = queue.pollFirst();
        for (int e : adj[curr]) {
            if (min_dis[e] == -1) {
                min_dis[e] = 1 + min_dis[curr];
                queue.addLast(e);
            }
        }
    }
    return min_dis;
}