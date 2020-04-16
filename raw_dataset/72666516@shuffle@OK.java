public static void shuffle(int[] data, int from, int to) {
    to--;
    for (int i = from; i <= to; i++) {
        int s = nextInt(i, to);
        int tmp = data[i];
        data[i] = data[s];
        data[s] = tmp;
    }
}