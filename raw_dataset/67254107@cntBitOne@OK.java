private int cntBitOne(String s) {
    int c = 0, n = s.length();
    for (int i = 0; i < n; i++) if (s.charAt(i) == '1')
        c++;
    return c;
}