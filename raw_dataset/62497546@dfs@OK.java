public static void dfs(int v, int color) {
    colors[v] = color;
    for (int to : gr[v]) {
        if (colors[to] == -1)
            dfs(to, (color + 1) % 3);
    }
}