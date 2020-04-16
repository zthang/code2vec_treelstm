static void union(int x, int y) {
    int xroot = find(x);
    int yroot = find(y);
    if (subsets[xroot].size < subsets[yroot].size) {
        subsets[xroot].parent = yroot;
        subsets[yroot].size += subsets[xroot].size;
    } else {
        subsets[yroot].parent = xroot;
        subsets[xroot].size += subsets[yroot].size;
    }
}