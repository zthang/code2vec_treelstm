static void dfs(int v, int pr, int ma, int com) {
    if (com != -1) {
        comp[v] = com;
        max[v] = ma;
        cnt[com]++;
        all.add(v);
    }
    for (edge to : gr[v]) {
        if (to.to == pr || killed[to.to])
            continue;
        dfs(to.to, v, Math.max(ma, to.cost), (com == -1 ? to.to : com));
    }
}