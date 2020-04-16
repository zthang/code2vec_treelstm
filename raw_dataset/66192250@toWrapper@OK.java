static Long[][] toWrapper(long[][] arr) {
    Long[][] res = new Long[arr.length][];
    for (int i = 0; i < arr.length; i++) {
        res[i] = toWrapper(arr[i]);
    }
    return res;
}