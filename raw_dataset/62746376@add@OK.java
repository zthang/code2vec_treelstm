void add(int v) {
    if (n >= a.length)
        a = Arrays.copyOf(a, (n << 2) + 8);
    a[n++] = v;
}