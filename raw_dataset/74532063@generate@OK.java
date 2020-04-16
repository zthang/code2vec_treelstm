public void generate(int x, int p, int he) {
    lca[x][0] = p;
    height[x] = he;
    for (int xx : adj[x]) {
        if (xx != p) {
            generate(xx, x, he + 1);
        }
    }
}