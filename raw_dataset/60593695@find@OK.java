public static int find(int x) {
    if (x == fa[x])
        return x;
    return fa[x] = find(fa[x]);
}