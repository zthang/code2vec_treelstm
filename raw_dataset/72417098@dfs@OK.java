static void dfs(int i) {
    if (i == k - 1)
        return;
    if (hs[p[i]].size() == 1) {
        if (!hs[p[i]].contains(p[i + 1])) {
            max++;
            min++;
        }
    } else {
        if (!hs[p[i]].contains(p[i + 1])) {
            max++;
            min++;
        } else
            max++;
    }
    dfs(i + 1);
}