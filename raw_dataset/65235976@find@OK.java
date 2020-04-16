public static int find(int x) {
    if (pre[x] == x)
        return x;
    return pre[x] = find(pre[x]);
}