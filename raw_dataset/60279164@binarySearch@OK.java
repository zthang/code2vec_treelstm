public static int binarySearch(long[] a, int index, long target) {
    int l = index;
    int h = a.length - 1;
    while (l <= h) {
        int med = l + (h - l) / 2;
        if (a[med] - target <= target) {
            l = med + 1;
        } else
            h = med - 1;
    }
    return h;
}