boolean scc() {
    System.arraycopy(deg, 0, cpDeg, 0, n);
    Arrays.sort(cpDeg);
    int tot = 0;
    for (int i = 1; i < n; i++) {
        tot += cpDeg[n - i];
        int bui = i * (n - i) + i * (i - 1) / 2;
        if (tot == bui)
            return false;
    }
    for (int i = 1; i < n; i++) {
        tot += cpDeg[i - 1];
        int bui = i * (i - 1) / 2;
        if (tot == bui)
            return false;
    }
    return true;
}