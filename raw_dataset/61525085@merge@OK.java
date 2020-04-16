public void merge(int x, int y) {
    int parX = find(x);
    int parY = find(y);
    if (parX != parY) {
        sum -= choose2(rank[parX]);
        sum -= choose2(rank[parY]);
        if (rank[parX] > rank[parY]) {
            par[parY] = parX;
            rank[parX] += rank[parY];
            sum += choose2(rank[parX]);
        } else {
            par[parX] = parY;
            rank[parY] += rank[parX];
            sum += choose2(rank[parY]);
        }
    }
}