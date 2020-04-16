int get(int a) {
    if (parent[a] == a)
        return a;
    return parent[a] = get(parent[a]);
}