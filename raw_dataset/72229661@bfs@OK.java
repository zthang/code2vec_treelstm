private void bfs(int start) {
    Queue<Pair> queue = new ArrayDeque<>();
    queue.add(new Pair(start, 0));
    while (!queue.isEmpty()) {
        Pair p = queue.poll();
        int now = p.x;
        int length = p.y;
        Pair distNow = dist[now];
        if (distNow.x < length) {
            continue;
        } else if (distNow.x == length) {
            distNow.y++;
            continue;
        }
        distNow.x = length;
        distNow.y++;
        for (int next : path[now]) {
            queue.add(new Pair(next, length + 1));
        }
    }
}