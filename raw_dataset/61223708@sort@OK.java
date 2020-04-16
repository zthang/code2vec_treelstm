static void sort(long[] ar) {
    Random rnd = ThreadLocalRandom.current();
    for (int i = ar.length - 1; i > 0; i--) {
        int index = rnd.nextInt(i + 1);
        // Simple swap
        long a = ar[index];
        ar[index] = ar[i];
        ar[i] = a;
    }
    Arrays.sort(ar);
}