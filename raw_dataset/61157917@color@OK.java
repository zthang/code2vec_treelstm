public static int color(int[] color, int[] a, int[] b) {
    int count = 0;
    boolean[][] check = new boolean[7][7];
    for (int i = 0; i < b.length; i++) {
        int l = a[i];
        int r = b[i];
        if (!check[color[l]][color[r]]) {
            count++;
            check[color[l]][color[r]] = true;
            check[color[r]][color[l]] = true;
        }
    }
    return count;
}