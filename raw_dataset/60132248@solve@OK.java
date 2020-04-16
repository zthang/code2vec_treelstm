void solve() {
    int n = scn.nextInt(), m = scn.nextInt();
    int[] to = new int[m], from = new int[m];
    for (int i = 0; i < m; i++) {
        from[i] = scn.nextInt() - 1;
        to[i] = scn.nextInt() - 1;
    }
    int[][] g = packD(n, from, to);
    if (sortTopologically(g) != null) {
        out.println(1);
        for (int i = 0; i < m; i++) {
            out.print(1 + " ");
        }
        out.println();
        return;
    }
    out.println(2);
    for (int i = 0; i < m; i++) {
        if (from[i] < to[i]) {
            out.print(1 + " ");
        } else {
            out.print(2 + " ");
        }
    }
    out.println();
}