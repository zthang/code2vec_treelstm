static void dfsl(int start, int par) {
    int aa = 0;
    for (Pair p : graph[start]) {
        if (p.u == par)
            continue;
        aa++;
        dfsl(p.u, start);
    }
    if (aa == 0) {
        leaf = start;
    }
}