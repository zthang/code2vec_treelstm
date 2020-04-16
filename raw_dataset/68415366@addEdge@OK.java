static void addEdge(int a, int b) {
    adjlist[a].add(b);
    adjlist[b].add(a);
}