private int count(int[] a, int[] b, int[] color) {
    int res = 0;
    int m = a.length;
    boolean[][] taken = new boolean[7][7];
    for (int i = 0; i < m; i++) {
        if (!taken[color[a[i]]][color[b[i]]]) {
            taken[color[a[i]]][color[b[i]]] = true;
            taken[color[b[i]]][color[a[i]]] = true;
            res++;
        }
    }
    return res;
}