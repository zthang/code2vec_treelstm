int getRoot() {
    for (int i = 1; i <= n; i++) {
        if (graph[i].size() == 1) {
            return i;
        }
    }
    return 0;
}