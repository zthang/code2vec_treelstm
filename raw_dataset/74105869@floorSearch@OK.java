public static int floorSearch(int l, int r, long val, long[] ar) {
    int mid;
    while (l + 1 != r && l < r) {
        mid = (l + r) / 2;
        if (ar[mid] > val)
            r = mid;
        else
            l = mid;
    }
    if (ar[r] <= val)
        return r;
    else if (ar[l] <= val)
        return l;
    else
        return -1;
}