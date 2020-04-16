private int[] getDist(int start, int n) {
    int[] dist = new int[n + 1];
    boolean[] vis = new boolean[n + 1];
    Queue<Pair<Integer, Integer>> queue = new ArrayDeque<>();
    queue.add(new Pair<>(start, 0));
    while (!queue.isEmpty()) {
        Pair<Integer, Integer> p = queue.poll();
        if (vis[p.getKey()]) {
            continue;
        }
        vis[p.getKey()] = true;
        dist[p.getKey()] = p.getValue();
        for (int next : path[p.getKey()]) {
            queue.add(new Pair<>(next, p.getValue() + 1));
        }
    }
    return dist;
}