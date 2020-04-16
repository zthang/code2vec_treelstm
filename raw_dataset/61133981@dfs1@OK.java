void dfs1(int v) {
    used[v] = true;
    for (int i = 0; i < gg[v].size(); i++) {
        if (!used[gg[v].get(i)]) {
            dfs1(gg[v].get(i));
        }
    }
    order.add(v);
}