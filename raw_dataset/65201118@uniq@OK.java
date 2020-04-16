long[] uniq(long[] arr) {
    arr = s.shuffle(arr);
    Arrays.sort(arr);
    long[] rv = new long[arr.length];
    int pos = 0;
    rv[pos++] = arr[0];
    for (int i = 1; i < arr.length; i++) {
        if (arr[i] != arr[i - 1]) {
            rv[pos++] = arr[i];
        }
    }
    return Arrays.copyOf(rv, pos);
}