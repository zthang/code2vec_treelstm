public static int find(int x) {
    int t = x;
    while (x != pre[x]) {
        x = pre[x];
    }
    while (x != t) {
        int tt = pre[t];
        pre[t] = x;
        t = tt;
    }
    return x;
}