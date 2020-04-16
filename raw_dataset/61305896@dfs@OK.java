static void dfs(int o) {
    B[o] = true;
    ans++;
    for (int i : gr[o]) if (!B[i])
        dfs(i);
}