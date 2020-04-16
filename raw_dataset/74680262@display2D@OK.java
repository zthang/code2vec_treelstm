void display2D(int[][] a) {
    for (int[] i : a) {
        for (int j : i) {
            out.print(j + " ");
        }
        out.println();
    }
}