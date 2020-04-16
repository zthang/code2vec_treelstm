static int kmp(String t, String p) {
    int[] f = new int[p.length() + 1];
    int i = 0;
    int j = 1;
    f[1] = 0;
    while (j < p.length()) {
        if (i == 0 || p.charAt(i - 1) == p.charAt(j - 1)) {
            i++;
            j++;
            f[j] = i;
        } else {
            i = f[i];
        }
    }
    i = 1;
    j = 1;
    while (i <= p.length() && j <= t.length()) {
        if (i == 0 || p.charAt(i - 1) == t.charAt(j - 1)) {
            i++;
            j++;
        } else {
            i = f[i];
        }
    }
    return i == (p.length() + 1) ? j - i : -1;
}