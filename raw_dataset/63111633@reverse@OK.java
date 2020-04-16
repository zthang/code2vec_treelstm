long[] reverse(long[] arr) {
    if (arr == null) {
        return null;
    }
    int l = 0, r = arr.length - 1;
    while (l < r) {
        arr[l] = arr[l] ^ arr[r];
        arr[r] = arr[l] ^ arr[r];
        arr[l] = arr[l] ^ arr[r];
        l++;
        r--;
    }
    return arr;
}