public long max(long[] A) {
    long max = Long.MAX_VALUE;
    for (int i = 0; i < A.length; i++) {
        max = Math.max(max, A[i]);
    }
    return max;
}