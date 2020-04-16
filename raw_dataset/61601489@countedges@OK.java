void countedges(int v) {
    was[v] = true;
    for (Integer e : graph[v]) {
        edges[(int) col[v]][(int) col[e]]++;
        if (!was[e])
            countedges(e);
    }
}