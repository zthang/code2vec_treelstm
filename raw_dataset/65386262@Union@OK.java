// A function that does union of two sets of x and y
// (uses union by rank)
void Union(subset[] subsets, int x, int y) {
    int xroot = find(subsets, x);
    int yroot = find(subsets, y);
    // (Union by Rank)
    if (subsets[xroot].rank < subsets[yroot].rank)
        subsets[xroot].parent = yroot;
    else if (subsets[xroot].rank > subsets[yroot].rank)
        subsets[yroot].parent = xroot;
    else // If ranks are same, then make one as root and increment
    // its rank by one
    {
        subsets[yroot].parent = xroot;
        subsets[xroot].rank++;
    }
}