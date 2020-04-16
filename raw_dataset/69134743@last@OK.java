int last(int[] a) {
    for (int i = a.length - 1; i >= 0; i--) {
        if (a[i] > 0)
            return i;
    }
    return -1;
}