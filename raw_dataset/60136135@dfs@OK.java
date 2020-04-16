int dfs(int i, int t, int h) {
    if (i == t)
        return 1;
    if (visited[i] == h)
        return 0;
    visited[i] = h;
    for (int l = ao[i]; l != 0; l = next[l]) if (used[zz[l]] == 1 && dfs(jj[l], t, h) == 1)
        return 1;
    return 0;
}