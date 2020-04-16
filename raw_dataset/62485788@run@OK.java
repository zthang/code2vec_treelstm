public static void run(int v, int p, int a, int b, int c, int k) {
    if (k == 0) {
        val += cost[v][a - 1];
        clone[v] = ch(a);
    }
    if (k == 1) {
        val += cost[v][b - 1];
        clone[v] = ch(b);
    }
    if (k == 2) {
        val += cost[v][c - 1];
        clone[v] = ch(c);
    }
    int next = (k + 1) % 3;
    for (int x : adj[v]) {
        if (x != p) {
            run(x, v, a, b, c, next);
            break;
        }
    }
}