void merge(int x, int y, Edge ed) {
    int parX = find(x);
    int parY = find(y);
    if (!on[parX] || !on[parY]) {
        if (parX != parY) {
            if (rank[parX] > rank[parY]) {
                on[parX] = (on[parY] || on[parX]);
                par[parY] = parX;
                rank[parX] += rank[parY];
                e[parX].addAll(e[parY]);
                e[parY].clear();
                e[parX].add(ed);
            } else {
                on[parY] = (on[parY] || on[parX]);
                par[parX] = parY;
                rank[parY] += rank[parX];
                e[parY].addAll(e[parX]);
                e[parX].clear();
                e[parY].add(ed);
            }
        }
    }
}