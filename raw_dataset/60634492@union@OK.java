void union(int s1, int s2) {
    int a = findSet(s1);
    int b = findSet(s2);
    if (a != b) {
        unconnected--;
        if (dsu_size[a] > dsu_size[b]) {
            int temp = a;
            a = b;
            b = temp;
        }
        dsu[a] = b;
        dsu_size[b] += dsu_size[a];
    }
}