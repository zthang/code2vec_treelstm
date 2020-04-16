public void __build() {
    generate(root, -1, 0);
    for (int j = 1; (1 << j) < n; j++) {
        for (int i = 0; i < n; i++) {
            if (lca[i][j - 1] != -1) {
                lca[i][j] = lca[lca[i][j - 1]][j - 1];
            }
        }
    }
}