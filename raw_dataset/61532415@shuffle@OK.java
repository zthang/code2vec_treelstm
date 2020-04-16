static void shuffle(long[] a) {
    for (int i = 0; i < a.length; i++) {
        int r = i + (int) (Math.random() * (a.length - i));
        long tmp = a[r];
        a[r] = a[i];
        a[i] = tmp;
    }
}