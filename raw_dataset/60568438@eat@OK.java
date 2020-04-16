private int eat(int node) {
    eaten[node] = true;
    int internal = 1;
    for (int child : graph.getEdgesFrom(node)) {
        if (!eaten[child]) {
            internal += eat(child);
        }
    }
    return internal;
}