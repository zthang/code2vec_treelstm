private static String getScore(String str, int k) {
    StringBuilder s = new StringBuilder();
    int val = str.length() - k;
    if (val % 2 == 1) {
        for (int i = k; i < str.length(); i++) {
            s.append(str.charAt(i));
        }
        for (int i = k - 1; i >= 0; i--) {
            s.append(str.charAt(i));
        }
    } else {
        for (int i = k; i < str.length(); i++) {
            s.append(str.charAt(i));
        }
        for (int i = 0; i < k; i++) {
            s.append(str.charAt(i));
        }
    }
    return s.toString();
}