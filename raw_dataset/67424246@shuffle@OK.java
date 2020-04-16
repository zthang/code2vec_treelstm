static void shuffle(int[] a) {
    for (int i = 0; i < a.length; i++) {
        int t = (int) Math.random() * a.length;
        int x = a[t];
        a[t] = a[i];
        a[i] = x;
    }
}