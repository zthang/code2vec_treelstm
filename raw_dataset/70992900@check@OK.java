long check(long[] arr) {
    long max = Long.MIN_VALUE;
    for (int i = 1; i < arr.length; i++) {
        max = Math.max(max, Math.abs(arr[i] - arr[i - 1]));
    }
    return max;
}