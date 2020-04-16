public void dfs(int mask) {
    if (done[mask])
        return;
    done[mask] = true;
    for (int i = 0; i < 26; i++) {
        if ((mask & (1 << i)) != 0) {
            dfs(mask ^ (1 << i));
        }
    }
}