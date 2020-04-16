private void bfs(int start) {
    Queue<Integer> queue = new ArrayDeque<>();
    queue.add(start);
    while (!queue.isEmpty()) {
        int c = queue.poll();
        int l = lengthFrom[c] + 1;
        for (int from : graph[c]) {
            if (lengthFrom[from] < l)
                continue;
            if (lengthFrom[from] == Integer.MAX_VALUE) {
                lengthFrom[from] = l;
                queue.add(from);
            }
            directions[from].add(c);
        }
    }
}