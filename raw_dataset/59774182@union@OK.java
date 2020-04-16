private void union(int a, int b) {
    int a_root = findRoot(a);
    int b_root = findRoot(b);
    if (a_root != b_root) {
        ans += (((long) size[a_root]) * size[b_root]);
        if (size[a_root] < size[b_root]) {
            disjointArray[a_root] = disjointArray[b_root];
            size[b_root] += size[a_root];
        } else {
            disjointArray[b_root] = disjointArray[a_root];
            size[a_root] += size[b_root];
        }
    }
}