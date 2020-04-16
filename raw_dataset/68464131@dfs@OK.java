static void dfs(int i) {
    if (v[i])
        return;
    v[i] = true;
    max = Math.max(i, max);
    min = Math.min(i, min);
    for (int j : arr[i]) dfs(j);
}