public static long[] shuffle(long[] a, Random gen) {
    int n = a.length;
    for (int i = 0; i < n; i++) {
        int ind = gen.nextInt(n - i) + i;
        long temp = a[ind];
        a[ind] = a[i];
        a[i] = temp;
    }
    return a;
}