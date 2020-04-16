static int count(long[] arr, long x, int n) {
    int l = 0;
    int h = n - 1;
    int res = -1;
    int mid = -1;
    while (l <= h) {
        mid = l + (h - l) / 2;
        if (x == arr[mid]) {
            res = mid;
            h = mid - 1;
        } else if (x < arr[mid])
            h = mid - 1;
        else
            l = mid + 1;
    }
    if (res == -1)
        return 0;
    // res is first index and res1 is last index of an element in a sorted array total number of occurences is (res1-res+1)
    int res1 = -1;
    l = 0;
    h = n - 1;
    while (l <= h) {
        mid = l + (h - l) / 2;
        if (x == arr[mid]) {
            res1 = mid;
            l = mid + 1;
        } else if (x < arr[mid])
            h = mid - 1;
        else
            l = mid + 1;
    }
    if (res1 == -1)
        return 0;
    if (res != -1 && res1 != -1)
        return (res1 - res + 1);
    return 0;
}