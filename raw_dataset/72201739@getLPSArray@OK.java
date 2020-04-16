private static int[] getLPSArray(String pattern) {
    int i, j, n = pattern.length();
    int[] lps = new int[pattern.length()];
    lps[0] = 0;
    for (i = 1, j = 0; i < n; ) {
        if (pattern.charAt(i) == pattern.charAt(j)) {
            lps[i++] = ++j;
        } else if (j > 0) {
            j = lps[j - 1];
        } else {
            lps[i++] = 0;
        }
    }
    return lps;
}