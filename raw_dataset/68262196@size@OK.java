static int size(int node) {
    size[node] = 1;
    for (int i : child[node]) size[node] += size(i);
    return size[node];
}