public long[] nextLongArray(int N, boolean oneBased) {
    if (oneBased) {
        long[] array = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            array[i] = sc.nextLong();
        }
        return array;
    } else {
        long[] array = new long[N];
        for (int i = 0; i < N; i++) {
            array[i] = sc.nextLong();
        }
        return array;
    }
}