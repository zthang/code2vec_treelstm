private static void dfsLast(int v) {
    was[v] = true;
    for (int son : vert[v]) {
        if (!was[son])
            dfsLast(son);
    }
}