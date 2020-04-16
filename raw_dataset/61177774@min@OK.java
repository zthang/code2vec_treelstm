public long min(long[] A) {
    long min = Long.MAX_VALUE;
    for (int i = 0; i < A.length; i++) {
        min = Math.min(min, A[i]);
    }
    return min;
}