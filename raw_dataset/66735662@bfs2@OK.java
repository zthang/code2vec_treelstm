public static void bfs2() {
    Queue<Integer> aaaa = new LinkedList<>();
    for (int i = 0; i < array.length; ++i) {
        if (array[i] % 2 == 1) {
            used[i] = true;
            dist2[i] = 0;
            aaaa.add(i);
        }
    }
    while (!aaaa.isEmpty()) {
        int node = aaaa.poll();
        for (Integer to : graph[node]) {
            if (!used[to]) {
                dist2[to] = dist2[node] + 1;
                used[to] = true;
                aaaa.add(to);
            }
        }
    }
}