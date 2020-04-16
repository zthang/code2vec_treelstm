static void shuffle(int[] a) {
    int n = a.length;
    Random rand = new Random();
    for (int i = 0; i < n; i++) {
        int tmpIdx = rand.nextInt(n);
        int tmp = a[i];
        a[i] = a[tmpIdx];
        a[tmpIdx] = tmp;
    }
}