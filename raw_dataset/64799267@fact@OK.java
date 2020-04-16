static void fact(long[] a) {
    a[0] = 1;
    for (int i = 1; i < a.length; i++) a[i] = (i * a[i - 1]) % mod;
}