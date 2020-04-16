void work() {
    int n = in.nextInt();
    int m = in.nextInt();
    int[][] Q = new int[m][2];
    int[][] E = new int[n - 1][3];
    for (int i = 0; i < n - 1; i++) {
        int s = in.nextInt() - 1;
        int e = in.nextInt() - 1;
        int w = in.nextInt();
        E[i][0] = w;
        E[i][1] = s;
        E[i][2] = e;
    }
    for (int i = 0; i < m; i++) {
        Q[i][0] = in.nextInt();
        Q[i][1] = i;
    }
    long[] ret = new long[m];
    Arrays.sort(Q, new Comparator<int[]>() {

        public int compare(int[] A, int[] B) {
            return A[0] - B[0];
        }
    });
    Arrays.sort(E, new Comparator<int[]>() {

        public int compare(int[] A, int[] B) {
            return A[0] - B[0];
        }
    });
    id = new int[n];
    count = new int[n];
    weight = new int[n];
    for (int i = 0; i < n; i++) id[i] = i;
    Arrays.fill(count, 1);
    long cnt = 0;
    for (int i = 0, j = 0; i < m; i++) {
        int w = Q[i][0];
        int index = Q[i][1];
        while (j < n - 1 && E[j][0] <= w) {
            int s = E[j][1];
            int e = E[j][2];
            int sroot = find(s);
            int eroot = find(e);
            cnt += union(sroot, eroot);
            j++;
        }
        ret[index] = cnt;
    }
    for (int i = 0; i < m; i++) {
        out.print(ret[i] + " ");
    }
}