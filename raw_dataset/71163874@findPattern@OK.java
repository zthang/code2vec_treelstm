private static List<Integer> findPattern(String text, String pattern) {
    List<Integer> matchedIndexes = new ArrayList<>();
    if (pattern.length() == 0) {
        return matchedIndexes;
    }
    int[] lps = getLPSArray(pattern);
    int i = 0, j = 0, n = text.length(), m = pattern.length();
    while (i < n) {
        if (text.charAt(i) == pattern.charAt(j)) {
            i++;
            j++;
        }
        if (j == m) {
            matchedIndexes.add(i - j);
            j = lps[j - 1];
        }
        if (i < n && text.charAt(i) != pattern.charAt(j)) {
            if (j > 0) {
                j = lps[j - 1];
            } else {
                i++;
            }
        }
    }
    return matchedIndexes;
}