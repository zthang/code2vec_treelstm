void dfs(int x, int y, int depth) {
    data[depth] = x;
    for (int i = h[x]; i != 0; i = nx[i]) {
        if (to[i] == y)
            continue;
        dfs(to[i], x, depth + 1);
    }
}