static void dfs(int n) {
    hs.add(n);
    int i, j;
    for (i = 0; i < grph.get(n).size(); ++i) {
        j = grph.get(n).get(i);
        if (!hs.contains(j))
            dfs(j);
    }
}