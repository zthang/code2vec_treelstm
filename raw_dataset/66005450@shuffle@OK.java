void shuffle(Object[] a) {
    Random r = new Random();
    for (int i = a.length - 1; i >= 0; i--) {
        int j = r.nextInt(a.length);
        Object t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}