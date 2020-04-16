static void h(int i, int he) {
    h[i] = he;
    for (int u : adj[i]) {
        if (u == up[i][0])
            continue;
        h(u, he + 1);
    }
}