static int find(int i) {
    if (parent[i] == 0) {
        parent[i] = i;
        return i;
    } else if (parent[i] == i) {
        return parent[i];
    } else {
        int res = find(parent[i]);
        parent[i] = res;
        return res;
    }
}