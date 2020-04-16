void bfs(int[] ans, List<Integer> s, List<Integer> ch) {
    int n = ans.length;
    int[] d = new int[n];
    Queue<Integer> q = new LinkedList<>();
    Arrays.fill(d, Integer.MAX_VALUE);
    for (int h : s) {
        d[h] = 0;
        q.add(h);
    }
    while (!q.isEmpty()) {
        int t = q.poll();
        for (int ver : list[t]) {
            if (d[ver] == Integer.MAX_VALUE) {
                d[ver] = d[t] + 1;
                q.add(ver);
            }
        }
    }
    for (int h : ch) {
        if (d[h] != Integer.MAX_VALUE)
            ans[h] = d[h];
    }
}