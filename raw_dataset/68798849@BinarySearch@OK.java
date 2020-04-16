public static int BinarySearch(long[] a, long k) {
    int n = a.length;
    int i = 0, j = n - 1;
    int mid = 0;
    if (k < a[0])
        return 0;
    else if (k >= a[n - 1])
        return n;
    else {
        while (j - i > 1) {
            mid = (i + j) / 2;
            if (k >= a[mid])
                i = mid;
            else
                j = mid;
        }
    }
    return i + 1;
}