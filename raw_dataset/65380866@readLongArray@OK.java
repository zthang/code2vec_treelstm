long[] readLongArray(int n) throws IOException {
    long[] answer = new long[n];
    for (int i = 0; i < n; ++i) {
        answer[i] = nextLong();
    }
    return answer;
}