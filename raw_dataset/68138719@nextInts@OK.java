public int[] nextInts(int N) {
    int[] res = new int[N];
    for (int i = 0; i < N; i++) {
        res[i] = (int) nextLong();
    }
    return res;
}