boolean next_perm(int[] a) {
    int len = a.length;
    for (int i = len - 2, j = 0; i >= 0; --i) {
        if (a[i] < a[i + 1]) {
            j = len - 1;
            for (; a[j] <= a[i]; --j) ;
            int p = a[j];
            a[j] = a[i];
            a[i] = p;
            j = i + 1;
            for (int ed = len - 1; j < ed; --ed) {
                p = a[ed];
                a[ed] = a[j];
                a[j++] = p;
            }
            return true;
        }
    }
    return false;
}