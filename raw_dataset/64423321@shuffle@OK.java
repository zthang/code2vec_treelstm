public static void shuffle(int[] a) {
    Random rnd = new Random();
    for (int i = a.length - 1; i >= 1; i--) {
        int j = rnd.nextInt(i + 1);
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}