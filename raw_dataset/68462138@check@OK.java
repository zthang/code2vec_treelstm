static int check(int i, int p) {
    int co = 0;
    for (int j : arr[i]) {
        if (j != p) {
            co += check(j, i);
        }
    }
    if (c[i] > co)
        f = true;
    return 1 + co;
}