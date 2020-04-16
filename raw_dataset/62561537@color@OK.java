static long color(int node, int grandparent, int parent, int you) {
    long sum = c[you][node];
    color[node] = you;
    for (int v : g[node]) {
        if (!visited[v]) {
            visited[v] = true;
            sum += color(v, parent, you, grandparent);
        }
    }
    return sum;
}