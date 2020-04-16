private boolean verify(int[][] adj, int[] color, int N) {
    int[] size = new int[3];
    for (int i = 0; i < N; i++) {
        size[color[i] - 1]++;
    }
    for (int i = 0; i < N; i++) {
        int c = color[i] - 1;
        if (adj[i].length != N - size[c])
            return true;
        for (int e : adj[i]) {
            if (color[e] == color[i]) {
                return true;
            }
        }
    }
    return false;
}