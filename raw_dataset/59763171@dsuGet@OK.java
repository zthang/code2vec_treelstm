int dsuGet(int v) {
    return v == parent[v] ? v : (parent[v] = dsuGet(parent[v]));
}