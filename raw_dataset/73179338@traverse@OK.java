public static void traverse(int at, int prev) {
    if (at == 0)
        res[at] = dif[at];
    else
        res[at] = dif[at] + Math.max(0, res[prev] - Math.max(0, dif[at]));
    for (int nxt : a[at]) {
        if (nxt != prev)
            traverse(nxt, at);
    }
}