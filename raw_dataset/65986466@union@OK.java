void union(int a, int b) {
    a = find(a);
    b = find(b);
    if (a != b)
        arr[b] = a;
}