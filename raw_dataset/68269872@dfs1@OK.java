static int dfs1(int v) {
    subcount[v] = 1;
    for (int vv : list.get(v)) subcount[v] += dfs1(vv);
    return subcount[v];
}