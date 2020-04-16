static void go1(int p, int at) {
    if (color[at] == 1)
        dp1[at]++;
    else
        dp1[at]--;
    for (int i : adj[at]) {
        if (i == p)
            continue;
        go1(at, i);
        dp1[at] += Math.max(0, dp1[i]);
    }
// System.out.println(dp1[at] + " " + at + " " + color[at]);
}