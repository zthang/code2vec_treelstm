static void reverse(int[] a, int l, int r) {
    for (int i = l; i < l + (r - l + 1) / 2; i++) {
        int temp = a[i];
        a[i] = a[l + r - i];
        a[l + r - i] = temp;
    }
}