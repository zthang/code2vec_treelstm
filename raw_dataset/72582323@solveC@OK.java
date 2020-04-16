private void solveC() throws IOException {
    int n = in.nextInt();
    StringBuilder s = new StringBuilder(in.next());
    for (char c = 'z'; c > 'a'; c--) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c && ((i > 0 && s.charAt(i - 1) == c - 1) || (i + 1 < s.length() && s.charAt(i + 1) == c - 1))) {
                s.deleteCharAt(i);
                i = max(-1, i - 2);
            }
        }
    }
    out.println(n - s.length());
}