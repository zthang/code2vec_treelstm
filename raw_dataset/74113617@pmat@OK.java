void pmat(int[][] a) {
    for (int i = 0; i < a.length; i++) {
        for (int j = 0; j < a[i].length; j++) {
            p(a[i][j] + " ");
        }
        pn("");
    }
}