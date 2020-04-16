/**
 * ***************************************Graph********************************************************
 */
static void Makegraph(int n) {
    graph = new HashSet[n];
    for (int i = 0; i < n; i++) {
        graph[i] = new HashSet<>();
    }
}