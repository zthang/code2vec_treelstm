private static void addEdge(Set<Integer>[] g, int i, int j) {
    g[i].add(j);
    g[j].add(i);
}