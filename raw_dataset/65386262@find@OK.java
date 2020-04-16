// A utility function to find set of an element i
// (uses path compression technique)
int find(subset[] subsets, int i) {
    // find root and make root as parent of i (path compression)
    if (subsets[i].parent != i)
        subsets[i].parent = find(subsets, subsets[i].parent);
    return subsets[i].parent;
}