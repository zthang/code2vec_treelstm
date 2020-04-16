public static boolean next_permutation(int[] a) {
    int i = 0, j = 0;
    int index = -1;
    int n = a.length;
    for (i = 0; i < n - 1; i++) if (a[i] < a[i + 1])
        index = i;
    if (index == -1)
        return false;
    i = index;
    for (j = i + 1; j < n && a[i] < a[j]; j++) ;
    int temp = a[i];
    a[i] = a[j - 1];
    a[j - 1] = temp;
    for (int p = i + 1, q = n - 1; p < q; p++, q--) {
        temp = a[p];
        a[p] = a[q];
        a[q] = temp;
    }
    return true;
}