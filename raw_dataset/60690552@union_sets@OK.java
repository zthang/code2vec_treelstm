static void union_sets(int a, int b) {
    a = find_set(a);
    b = find_set(b);
    if (a != b) {
        snm[b] = a;
        size[a] += size[b];
    }
}