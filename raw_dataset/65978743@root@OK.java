int root(int i) {
    while (arr[i] != i) {
        i = arr[i];
    }
    return i;
}