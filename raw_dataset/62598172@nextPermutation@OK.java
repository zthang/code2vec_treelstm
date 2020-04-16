static boolean nextPermutation(int[] a) {
    for (int i = a.length - 2; i >= 0; --i) {
        if (a[i] < a[i + 1]) {
            for (int j = a.length - 1; ; --j) {
                if (a[i] < a[j]) {
                    int t = a[i];
                    a[i] = a[j];
                    a[j] = t;
                    for (i++, j = a.length - 1; i < j; ++i, --j) {
                        t = a[i];
                        a[i] = a[j];
                        a[j] = t;
                    }
                    return true;
                }
            }
        }
    }
    return false;
}