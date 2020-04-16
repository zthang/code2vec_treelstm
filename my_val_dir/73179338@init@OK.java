public static void init(int at, int prev) {
    for (int nxt : a[at]) {
        if (nxt == prev)
            continue;
        init(nxt, at);
        dif[at] += Math.max(0, dif[nxt]);
    }
    if (color[at] == 1)
        dif[at]++;
    else
        dif[at]--;
}