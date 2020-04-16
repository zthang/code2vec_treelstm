void swap(int i, int j, int[] a) {
    a[i] ^= a[j];
    a[j] ^= a[i];
    a[i] ^= a[j];
}