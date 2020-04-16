public static long[] toLongArray(int[] arr) {
    return Arrays.stream(arr).mapToLong(a -> a).toArray();
}