void makechain(int node, int pa) {
    chain[ptr++] = node;
    for (int k : g[node]) {
        if (k != pa) {
            makechain(k, node);
        }
    }
}