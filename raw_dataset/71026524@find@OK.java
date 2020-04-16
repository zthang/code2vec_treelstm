static int find(Subset[] Subsets, int i) {
    if (Subsets[i].parent != i)
        Subsets[i].parent = find(Subsets, Subsets[i].parent);
    return Subsets[i].parent;
}