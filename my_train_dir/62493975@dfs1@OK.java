static void dfs1(int start, int par) {
    int aa = 0;
    for (Pair p : graph[start]) {
        if (p.u == par)
            continue;
        dfs1(p.u, start);
        aa++;
    }
    if (par == -1 && aa >= 3 || par != -1 && aa >= 2) {
        possible = true;
    }
}