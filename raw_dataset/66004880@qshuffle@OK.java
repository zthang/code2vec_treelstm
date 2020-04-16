void qshuffle(int[] a) {
    // QUICK shuffle
    int m = new Random().nextInt(10) + 2;
    for (int i = 0, n = a.length, j = m % n, t; i < n; t = a[i], a[i] = a[j], a[j] = t, i++, j = (i * m) % n) ;
}