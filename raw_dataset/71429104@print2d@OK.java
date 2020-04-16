public void print2d(int[][] a, PrintWriter out) {
    for (int i = 0; i < a.length; i++) {
        for (int j = 0; j < a[i].length; j++) out.print(a[i][j] + " ");
        out.println();
    }
    out.println();
}