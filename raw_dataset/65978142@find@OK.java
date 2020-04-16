int find(int value) {
    int par = parent[value];
    if (par == value)
        return par;
    parent[value] = find(par);
    return parent[value];
}