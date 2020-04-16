static int maximize(int[] vertexPiece, int vertex) {
    if (vertex == n) {
        // count and return
        boolean[][] dominos = new boolean[6][6];
        for (int i = 0; i < n; i++) {
            for (Integer j : adjList.get(i)) {
                dominos[vertexPiece[i]][vertexPiece[j]] = true;
            }
        }
        int count = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j <= i; j++) {
                if (dominos[i][j])
                    count++;
            }
        }
        return count;
    }
    // try and expand
    int max = -1;
    for (int j = 0; j < 6; j++) {
        vertexPiece[vertex] = j;
        max = Math.max(max, maximize(vertexPiece, vertex + 1));
    }
    return max;
}