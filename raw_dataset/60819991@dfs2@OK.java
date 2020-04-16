static long dfs2(int i) {
    long ans = 0;
    for (int j : g2.get(i)) ans = max(ans, dfs2(j));
    return ans + w[i];
}