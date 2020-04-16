static void print(char[][] a) {
    for (int i = 0; i < a.length; i++) {
        for (int j = 0; j < a.length; j++) {
            out.print(a[i][j]);
        }
        out.println();
    }
}