static String LPS(String s) {
    String snew = preprocess(s);
    int n = snew.length();
    // System.out.println(snew);
    int c = 0, r = 0;
    int maxlen = 0;
    int index = 0;
    int[] len = new int[n];
    for (int i = 1; i < n - 1; i++) {
        int mirr = c - (i - c);
        if (i < r) {
            len[i] = Math.min(len[mirr], r - i);
        }
        // System.out.println(i+" ");
        while (snew.charAt(i + len[i]) == snew.charAt(i - len[i])) len[i]++;
        if (i + len[i] > r) {
            c = i;
            r = i + len[i];
        }
        // System.out.println(c+" "+i+" "+snew.charAt(i)+" "+len[i]+" "+maxlen+" "+index);
        if (len[i] > maxlen) {
            // System.out.println("inside");
            maxlen = len[i];
            index = i;
        }
    }
    maxlen--;
    int left = (index - maxlen - 1) / 2;
    int right = left + maxlen;
    return s.substring(left, right);
}