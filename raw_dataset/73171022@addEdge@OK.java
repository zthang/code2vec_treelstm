void addEdge(int a, int b) {
    next[++ref] = head[a];
    head[a] = ref;
    to[ref] = b;
}