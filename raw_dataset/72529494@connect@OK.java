private boolean connect(int p, int q, int r, int s, char d1, char d2) {
    if (x[r][s] == -1) {
        mat[p][q] = d1;
        if (mat[r][s] == '0')
            mat[r][s] = d2;
        return true;
    }
    return false;
}