public static int bs(int[] z, int k) {
    int res = 0;
    int l = 0;
    int r = z.length - 1;
    int mid = (l + r) / 2;
    while (l <= r) {
        if (z[mid] == k) {
            res = 1;
            break;
        }
        if (z[mid] > k) {
            r = mid - 1;
        } else {
            l = mid + 1;
        }
        mid = (l + r) / 2;
    }
    return res;
}