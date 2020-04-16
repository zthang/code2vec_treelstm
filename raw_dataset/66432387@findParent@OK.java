private static int findParent(int[] parent, int i) {
    if (parent[i] == i)
        return i;
    return (parent[i] = findParent(parent, parent[i]));
}