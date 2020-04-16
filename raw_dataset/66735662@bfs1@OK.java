public static void bfs1() {
    Queue<Integer> aaaa = new LinkedList<>();
    for (int i = 0; i < array.length; ++i) {
        if (array[i] % 2 == 0) {
            used[i] = true;
            dist1[i] = 0;
            aaaa.add(i);
        }
    }
    while (!aaaa.isEmpty()) {
        int node = aaaa.poll();
        for (Integer to : graph[node]) {
            if (!used[to]) {
                dist1[to] = dist1[node] + 1;
                used[to] = true;
                aaaa.add(to);
            }
        }
    }
}