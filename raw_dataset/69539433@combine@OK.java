void combine(int a, int b) {
    a = findSet(a);
    b = findSet(b);
    if (a == b)
        return;
    jum--;
    if (size[a] > size[b]) {
        p[b] = a;
        size[a] += size[b];
    } else {
        p[a] = b;
        size[b] += size[a];
    }
}