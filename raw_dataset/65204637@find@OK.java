public int find(int p) {
    if (parent[p] == p) {
        return p;
    } else {
        return find(parent[p]);
    }
}