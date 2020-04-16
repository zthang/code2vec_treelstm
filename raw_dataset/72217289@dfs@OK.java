static void dfs(int i) {
    if (i == k - 1)
        return;
    if (set[p[i]].size() == 1) {
        if (!set[p[i]].contains(p[i + 1])) {
            max++;
            min++;
        }
    } else {
        if (!set[p[i]].contains(p[i + 1])) {
            max++;
            min++;
        } else
            max++;
    }
    dfs(i + 1);
}