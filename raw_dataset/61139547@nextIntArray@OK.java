public int[] nextIntArray(int N, boolean oneBased) {
    if (oneBased) {
        int[] array = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            array[i] = sc.nextInt();
        }
        return array;
    } else {
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = sc.nextInt();
        }
        return array;
    }
}