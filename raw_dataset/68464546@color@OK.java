int color(int v, int c) {
    colors[v] = c;
    int sz = 0;
    for (int e : edges[v]) {
        if (colors[e] == 0)
            sz += color(e, c);
    }
    return sz + 1;
}