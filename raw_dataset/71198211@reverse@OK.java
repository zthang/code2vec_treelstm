public static void reverse(int[] min, int i, int j) {
    int l = i;
    int r = j;
    while (l <= r) {
        int tmp = min[l];
        min[l] = min[r];
        min[r] = tmp;
        l++;
        r--;
    }
}