static void shufflel(long[] a) {
    for (int i = 0; i < a.length; i++) {
        int t = (int) Math.random() * a.length;
        long x = a[t];
        a[t] = a[i];
        a[i] = x;
    }
}