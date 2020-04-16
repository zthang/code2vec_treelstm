public String[] nextStringArray(int n) {
    String[] a = new String[n];
    for (int i = 0; i < n; i++) a[i] = next();
    return a;
}