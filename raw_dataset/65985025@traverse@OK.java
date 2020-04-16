public void traverse(int node) {
    if (visited[node]) {
        return;
    }
    visited[node] = true;
    for (int i = 0; i < 26; i++) {
        if (list[node][i]) {
            traverse(i);
        }
    }
}