public void union(int a, int b) {
    a = find(a);
    b = find(b);
    if (rnd.nextBoolean()) {
        int tmp = a;
        a = b;
        b = tmp;
    }
    arr[b] = a;
}