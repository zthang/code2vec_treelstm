static long[][] toPrimitive(Long[][] arr) {
    long[][] res = new long[arr.length][];
    for (int i = 0; i < arr.length; i++) {
        res[i] = toPrimitive(arr[i]);
    }
    return res;
}