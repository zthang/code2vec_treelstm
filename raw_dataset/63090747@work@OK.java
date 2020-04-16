boolean work() {
    int n = in.nextInt();
    int m = in.nextInt();
    graph = (ArrayList<Integer>[]) new ArrayList[n];
    for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
    int[] degree = new int[n];
    int[] C = new int[3];
    color = new int[n];
    Arrays.fill(color, 1);
    int one = 0, two = 0;
    for (int i = 0; i < m; i++) {
        int n1 = in.nextInt() - 1;
        int n2 = in.nextInt() - 1;
        graph[n1].add(n2);
        graph[n2].add(n1);
        degree[n1]++;
        degree[n2]++;
        if (i == 0) {
            color[n1] = 1;
            color[n2] = 2;
            one = n1;
            two = n2;
        }
    }
    // 1.染色
    for (int nn : graph[one]) {
        color[nn] = 2;
    }
    for (int nn : graph[two]) {
        if (color[nn] == 2)
            color[nn] = 3;
    }
    for (int i = 0; i < n; i++) {
        C[color[i] - 1]++;
    }
    if (C[2] == 0)
        return false;
    // 2.检查相邻是否颜色相同，和是否断开
    int[] count = new int[1];
    if (!dfs(0, new boolean[n], count) || count[0] != n) {
        return false;
    }
    // 3。检测入度
    for (int i = 0; i < n; i++) {
        if (degree[i] != n - C[color[i] - 1]) {
            return false;
        }
    }
    for (int i = 0; i < n; i++) out.print(color[i] + " ");
    return true;
}