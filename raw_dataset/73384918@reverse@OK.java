public static void reverse(int[] data, int l, int r) {
    while (l < r) {
        swap(data, l, r);
        l++;
        r--;
    }
}