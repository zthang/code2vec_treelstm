void reverse(int[] a, int l, int r) {
    while (l < r) {
        int tep = a[l];
        a[l] = a[r];
        a[r] = tep;
        l++;
        r--;
    }
}