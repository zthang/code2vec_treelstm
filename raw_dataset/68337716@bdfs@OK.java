void bdfs(int u, int pa) {
    int max1 = bd[u], n1 = pa, max2 = 0, n2 = 0;
    for (int v : ja[u]) {
        if (v == pa)
            continue;
        int val = d[v] + 1;
        if (val > max1) {
            max2 = max1;
            n2 = n1;
            max1 = val;
            n1 = v;
        } else if (val > max2) {
            max2 = val;
            n2 = v;
        }
    }
    for (int v : ja[u]) {
        if (v == pa)
            continue;
        bd[v] = (v == n1 ? max2 : max1) + 1;
        bdfs(v, u);
    }
}