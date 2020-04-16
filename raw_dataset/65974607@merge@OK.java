void merge(int x, int y) {
    int parX = par[x];
    int parY = par[y];
    if (parX != parY) {
        if (rank[parX] > rank[parY]) {
            par[parY] = parX;
            rank[parX] += rank[parY];
        } else {
            par[parX] = parY;
            rank[parY] += rank[parX];
        }
    }
}