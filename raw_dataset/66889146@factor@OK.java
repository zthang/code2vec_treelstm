static void factor(int n) {
    if (si[n] == n) {
        f.add(n);
        return;
    }
    f.add(si[n]);
    factor(n / si[n]);
}