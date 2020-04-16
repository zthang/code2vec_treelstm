public int getSingle(int id) {
    int lca1 = id > 0 ? lca(con[id - 1], con[id]) : 0;
    int lca2 = id < N - 1 ? lca(con[id], con[id + 1]) : 0;
    return from(con[id], lower(lca1, lca2));
}