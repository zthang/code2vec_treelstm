static int[] getPi(char[] a) {
    int m = a.length;
    int j = 0;
    int[] pi = new int[m];
    for (int i = 1; i < m; ++i) {
        while (j > 0 && a[i] != a[j]) j = pi[j - 1];
        if (a[i] == a[j]) {
            pi[i] = j + 1;
            j++;
        }
    }
    return pi;
}