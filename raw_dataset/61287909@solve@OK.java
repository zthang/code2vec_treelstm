static void solve(PrintWriter pw) {
    int[][] G = adjD(N, A, B);
    int[] order = khan(N, G);
    if (order != null) {
        pw.println(1);
        for (int i = 0; i < M; i++) {
            if (i != 0)
                pw.print(" ");
            pw.print(1);
        }
        pw.println();
    } else {
        pw.println(2);
        for (int i = 0; i < M; i++) {
            if (i != 0)
                pw.print(" ");
            if (A[i] < B[i]) {
                pw.print(1);
            } else {
                pw.print(2);
            }
        }
        pw.println();
    }
}