// Only valid indexes come
private static boolean isSameParity(int n1, int n2, int[] arr) {
    return ((arr[n1] ^ arr[n2]) & 1) == 0;
}