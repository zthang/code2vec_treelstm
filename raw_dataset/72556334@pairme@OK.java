static boolean pairme(int i, int j) {
    // pairing to make cycle if -1 -1 and not already fiiled or filling if filled
    if (mat[i - 1][j][0] == -1 && mat[i - 1][j][1] == -1) {
        a[i][j] = 'U';
        if (a[i - 1][j] != '\0')
            a[i - 1][j] = 'D';
        return true;
    } else if (mat[i + 1][j][0] == -1 && mat[i + 1][j][1] == -1) {
        if (a[i + 1][j] != '\0')
            a[i + 1][j] = 'U';
        a[i][j] = 'D';
        return true;
    } else if (mat[i][j - 1][0] == -1 && mat[i][j - 1][1] == -1) {
        a[i][j] = 'L';
        if (a[i][j - 1] != '\0')
            a[i][j - 1] = 'R';
        return true;
    } else if (mat[i][j + 1][0] == -1 && mat[i][j + 1][1] == -1) {
        a[i][j] = 'R';
        if (a[i][j + 1] != '\0')
            a[i][j + 1] = 'L';
        return true;
    }
    return false;
}