void shuffleInt(int[] a) {
    Random random = new Random();
    for (int i = a.length - 1; i > 0; i--) {
        int j = random.nextInt(i + 1);
        int swap = a[j];
        a[j] = a[i];
        a[i] = swap;
    }
}