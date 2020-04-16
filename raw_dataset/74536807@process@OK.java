static void process() {
    for (int j = 1; j < log; j++) {
        for (int i = 0; i < V; i++) {
            if (up[i][j - 1] == -1)
                continue;
            up[i][j] = up[up[i][j - 1]][j - 1];
        }
    }
}