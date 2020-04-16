static int compare(int length, int a, int b) {
    if (length == 0) {
        return 0;
    }
    for (int i = 31 - Integer.numberOfLeadingZeros(length - 1); i >= 0; i--) {
        if (prevs[i][a] != prevs[i][b]) {
            a = prevs[i][a];
            b = prevs[i][b];
        }
    }
    return Integer.compare(vals[a], vals[b]);
}