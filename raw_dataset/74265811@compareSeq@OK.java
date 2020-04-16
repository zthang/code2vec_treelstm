static boolean compareSeq(char[] S, int x, int y, int n) {
    for (int i = 0; i < n; i++) {
        if (S[x] < S[y])
            return true;
        else if (S[x] > S[y])
            return false;
        x = (x + 1) % n;
        y = (y + 1) % n;
    }
    return true;
}