static void shuffle(long[] a) {
    Random get = new Random();
    for (int i = 0; i < a.length; i++) {
        int r = get.nextInt(a.length);
        long temp = a[i];
        a[i] = a[r];
        a[r] = temp;
    }
}