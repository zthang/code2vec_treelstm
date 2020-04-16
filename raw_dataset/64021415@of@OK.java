public static PrefixSums of(long[] ar) {
    long[] sums = new long[ar.length + 1];
    for (int i = 1; i <= ar.length; i++) {
        sums[i] = sums[i - 1] + ar[i - 1];
    }
    return new PrefixSums(sums);
}