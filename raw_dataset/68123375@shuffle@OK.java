static void shuffle(long[] a) {
    Random r = new Random();
    for (int i = a.length - 1; i > 0; --i) {
        int si = r.nextInt(i);
        long t = a[si];
        a[si] = a[i];
        a[i] = t;
    }
}