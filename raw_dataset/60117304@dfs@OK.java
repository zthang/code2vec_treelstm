public static void dfs(int node, int col) {
    color[node] = Color.progress;
    for (int next : adjList[node]) {
        if (color[next] == Color.progress) {
            count = 2;
            edgeColor[edgeID[node][next]] = (col + 1) % 2;
        } else if (color[next] == Color.none) {
            edgeColor[edgeID[node][next]] = col;
            dfs(next, col);
        }
    }
    color[node] = Color.done;
}