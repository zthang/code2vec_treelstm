void dfs1(int x) {
    used[x] = true;
    for (int to : er[x]) {
        if (!used[to]) {
            dfs1(to);
        }
    }
    order[time++] = x;
}