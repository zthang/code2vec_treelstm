void shuffleArray(long[] ar) {
    Random rnd = ThreadLocalRandom.current();
    for (int i = ar.length - 1; i > 0; i--) {
        int index = rnd.nextInt(i + 1);
        long a = ar[index];
        ar[index] = ar[i];
        ar[i] = a;
    }
}