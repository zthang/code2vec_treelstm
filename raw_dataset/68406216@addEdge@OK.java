static void addEdge(List<Integer>[] adjlist, int a, int b) {
    adjlist[a].add(b);
    adjlist[b].add(a);
}