static void addMetaNode(int u, int id) {
    component[u] = id;
    for (int v : graph[u]) {
        if (component[v] == -1 && !not[u].contains(v)) {
            addMetaNode(v, id);
        }
    }
}