public static void addUndirectedEdge(List<UndirectedEdge>[] g, int s, int t) {
    UndirectedEdge toT = new UndirectedEdge(t);
    UndirectedEdge toS = new UndirectedEdge(s);
    toT.rev = toS;
    toS.rev = toT;
    g[s].add(toT);
    g[t].add(toS);
}