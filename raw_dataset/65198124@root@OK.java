int root(int r) {
    while (arr[r] != r) {
        arr[r] = arr[arr[r]];
        r = arr[r];
    }
    return r;
}