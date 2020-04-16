static void union(int i, int j) {
    int iRep = find(i);
    int jRep = find(j);
    parent[iRep] = jRep;
}