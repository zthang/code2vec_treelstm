static int check() {
    for (int i = 0; i < 7; i++) {
        for (int j = 0; j < 7; j++) {
            checkArr[i][j] = 0;
        }
    }
    for (int i = 1; i < n + 1; i++) {
        for (int son : vert[i]) {
            checkArr[arr[son]][arr[i]] = 1;
            checkArr[arr[i]][arr[son]] = 1;
        }
    }
    int maxim = 0;
    for (int i = 1; i < 7; i++) {
        for (int j = i; j < 7; j++) {
            maxim += checkArr[i][j];
        }
    }
    return maxim;
}