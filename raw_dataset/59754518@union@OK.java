public static void union(int u, int v) {
    int findv = find(v);
    int findu = find(u);
    answer -= comb[sizes[findu]];
    answer -= comb[sizes[findv]];
    sizes[findv] += sizes[findu];
    parent[findu] = findv;
    answer += comb[sizes[findv]];
}