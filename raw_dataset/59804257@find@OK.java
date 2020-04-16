int find(int n) {
    while (id[n] != n) n = id[n];
    return n;
}