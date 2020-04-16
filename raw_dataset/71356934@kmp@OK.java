private int kmp() {
    List<Integer> prefixTable = getPrefixTable(s);
    int match = 0;
    int i = 0;
    int j = 0;
    int n = t.length;
    int m = s.length;
    while (i < n) {
        if (t[i] == s[j]) {
            if (j == m - 1) {
                match++;
                j = prefixTable.get(j - 1);
                continue;
            }
            i++;
            j++;
        } else if (j > 0) {
            j = prefixTable.get(j - 1);
        } else {
            i++;
        }
    }
    return match;
}