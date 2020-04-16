private void parent(int now) {
    for (int i : tree[now]) {
        if (visited[i]) {
            parent[now] = i;
            break;
        }
    }
    visited[now] = true;
    for (int i : tree[now]) {
        if (!visited[i])
            parent(i);
    }
}