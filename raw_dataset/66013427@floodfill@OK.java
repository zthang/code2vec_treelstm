void floodfill(int n) {
    for (int i = 0; i < 26; i++) {
        if (graph[n][i] && letterUsed[i]) {
            letterUsed[i] = false;
            floodfill(i);
        }
    }
}