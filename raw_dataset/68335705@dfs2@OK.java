public static void dfs2(int x) {
    check[x] = true;
    int res = tree.search(c[x]);
    a[x] = res + 1;
    tree.update(res, -1);
    for (int y : list[x]) {
        if (!check[y]) {
            check[y] = true;
            dfs2(y);
        }
    }
}