private static void union(int x, int y) {
    int xroot = find(x);
    int yroot = find(y);
    if (subsets[xroot].rank < subsets[yroot].rank)
        subsets[xroot].parent = yroot;
    else if (subsets[yroot].rank < subsets[xroot].rank)
        subsets[yroot].parent = xroot;
    else {
        subsets[xroot].parent = yroot;
        subsets[yroot].rank++;
    }
}