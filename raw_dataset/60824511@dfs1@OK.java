boolean dfs1(int at, int p) {
    v[at] = true;
    for (int to : G[at]) {
        if (to == p)
            continue;
        if (v[to])
            conn[at] = true;
        else
            conn[at] |= dfs1(to, at);
    }
    return conn[at];
}