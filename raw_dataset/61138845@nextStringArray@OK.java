String[] nextStringArray(int n) {
    String[] res = new String[n];
    for (int i = 0; i < n; i++) res[i] = nextToken();
    return res;
}