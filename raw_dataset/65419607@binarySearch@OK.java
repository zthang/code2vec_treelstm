static int binarySearch(long[] arr, long x) {
    int l = 0, r = arr.length - 1;
    while (l <= r) {
        int m = l + (r - l) / 2;
        // Check if x is present at mid
        if (arr[m] == x)
            return m;
        // If x greater, ignore left half
        if (arr[m] < x)
            l = m + 1;
        else
            // If x is smaller, ignore right half
            r = m - 1;
    }
    // not present
    return -1;
}