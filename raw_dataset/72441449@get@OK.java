public char get(int i, int j, int ni, int nj) {
    if (i < ni) {
        return 'D';
    }
    if (i > ni) {
        return 'U';
    }
    if (j < nj) {
        return 'R';
    }
    if (j > nj) {
        return 'L';
    }
    return 'X';
}