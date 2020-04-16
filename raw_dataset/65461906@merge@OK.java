public void merge(int x, int y) {
    int xRep = findRep(x);
    int yRep = findRep(y);
    if (xRep == yRep) {
        return;
    }
    if (rank[xRep] < rank[yRep]) {
        parent[xRep] = yRep;
    } else if (rank[yRep] < rank[xRep]) {
        parent[yRep] = xRep;
    } else {
        parent[yRep] = xRep;
        rank[xRep]++;
    }
    componentCount--;
}