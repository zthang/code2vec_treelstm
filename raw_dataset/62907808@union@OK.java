static void union(int x, int y, int[] rank, int[] parent) {
    // Find representatives of two sets
    int xRoot = find(x, parent), yRoot = find(y, parent);
    // to unite anything.
    if (xRoot == yRoot)
        return;
    // If x's rank is less than y's rank
    if (rank[xRoot] < rank[yRoot])
        // Then move x under y  so that depth
        // of tree remains less
        parent[xRoot] = yRoot;
    else // Else if y's rank is less than x's rank
    if (rank[yRoot] < rank[xRoot])
        // Then move y under x so that depth of
        // tree remains less
        parent[yRoot] = xRoot;
    else // if ranks are the same
    {
        // Then move y under x (doesn't matter
        // which one goes where)
        parent[yRoot] = xRoot;
        // And increment the the result tree's
        // rank by 1
        rank[xRoot] = rank[xRoot] + 1;
    }
}