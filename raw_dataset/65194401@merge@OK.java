void merge(int x, int y) {
    int parX = find(x);
    int parY = find(y);
    if (parX != parY) {
        res++;
        if (rank[parX] > rank[parY]) {
            par[parY] = parX;
            rank[parX] += rank[parX];
            min[parX] = Math.min(min[parX], min[parY]);
            max[parX] = Math.max(max[parX], max[parY]);
        } else {
            par[parX] = parY;
            rank[parY] += rank[parX];
            min[parY] = Math.min(min[parX], min[parY]);
            max[parY] = Math.max(max[parX], max[parY]);
        }
    }
}