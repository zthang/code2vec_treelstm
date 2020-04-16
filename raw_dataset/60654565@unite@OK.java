public void unite(int a, int b) {
    a = find(a);
    b = find(b);
    if (a != b) {
        if (size[a] < size[b]) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        parents[b] = a;
        size[a] += size[b];
    }
}