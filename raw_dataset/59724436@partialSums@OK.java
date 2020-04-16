public static long[] partialSums(long[] array) {
    long[] result = new long[array.length + 1];
    for (int i = 0; i < array.length; i++) {
        result[i + 1] = result[i] + array[i];
    }
    return result;
}