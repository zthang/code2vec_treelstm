void dfs2(int v) {
    used[v] = true;
    component.add(v);
    for (int i = 0; i < ggr[v].size(); i++) {
        if (!used[ggr[v].get(i)]) {
            dfs2(ggr[v].get(i));
        }
    }
}