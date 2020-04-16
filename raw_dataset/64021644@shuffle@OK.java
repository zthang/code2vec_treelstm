public static void shuffle(long[] array) {
    Random random = new Random();
    int n = array.length;
    for (int i = 0; i < n; i++) {
        int randomIndex = i + random.nextInt(n - i);
        long temp = array[i];
        array[i] = array[randomIndex];
        array[randomIndex] = temp;
    }
}