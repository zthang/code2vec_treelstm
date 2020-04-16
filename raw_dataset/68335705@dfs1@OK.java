public static int dfs1(int x) {
    check[x] = true;
    for (int y : list[x]) {
        if (!check[y]) {
            check[y] = true;
            size[x] += dfs1(y) + 1;
        }
    }
    if (size[x] < c[x]) {
        System.out.println("NO");
        System.exit(0);
    }
    return size[x];
}