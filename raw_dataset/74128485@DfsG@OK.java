static void DfsG(int o) {
    c[o] = true;
    s++;
    int u = 0;
    for (int i : G[o]) {
        if (!v[i]) {
            DfsB(i);
            u++;
        }
    }
    if (u == 0)
        g = o;
}