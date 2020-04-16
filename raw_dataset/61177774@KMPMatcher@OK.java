public ArrayList<Integer> KMPMatcher(char[] text, char[] pattern) {
    int[] lps = computeTemporalArray(pattern);
    int j = 0;
    int i = 0;
    int n = text.length;
    int m = pattern.length;
    ArrayList<Integer> indices = new ArrayList<>();
    while (i < n) {
        if (pattern[j] == text[i]) {
            i++;
            j++;
        }
        if (j == m) {
            indices.add(i - j);
            j = lps[j - 1];
        } else if (i < n && pattern[j] != text[i]) {
            if (j != 0)
                j = lps[j - 1];
            else
                i = i + 1;
        }
    }
    return indices;
}