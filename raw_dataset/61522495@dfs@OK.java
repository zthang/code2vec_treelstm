static void dfs(int cur, int[] colors) {
    if (colors[cur] > 0)
        return;
    Arrays.fill(av, 0);
    for (int next : graph[cur]) {
        av[colors[next]] = 1;
    }
    int min = 4;
    for (int i = 1; i < 4; i++) if (av[i] == 0)
        min = i;
    if (min == 4) {
        System.out.println(-1);
        System.exit(0);
    }
    colors[cur] = min;
    for (int next : graph[cur]) {
        dfs(next, colors);
    }
}