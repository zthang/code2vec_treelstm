static void union(Subset[] Subsets, int x, int y) {
    int xroot = find(Subsets, x);
    int yroot = find(Subsets, y);
    if (Subsets[xroot].rank < Subsets[yroot].rank)
        Subsets[xroot].parent = yroot;
    else if (Subsets[yroot].rank < Subsets[xroot].rank)
        Subsets[yroot].parent = xroot;
    else {
        Subsets[xroot].parent = yroot;
        Subsets[yroot].rank++;
    }
}