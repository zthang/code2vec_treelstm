void work() {
    int n = in.nextInt();
    id = new int[n + 1];
    for (int i = 0; i <= n; i++) id[i] = i;
    long[] A = new long[n];
    long[] B = new long[n];
    long[][] C = new long[n][];
    for (int i = 0; i < n; i++) C[i] = new long[] { in.nextLong(), in.nextLong() };
    for (int i = 0; i < n; i++) A[i] = in.nextLong();
    for (int i = 0; i < n; i++) B[i] = in.nextLong();
    long[][] E = new long[n * (n + 1) / 2][];
    int p = 0;
    for (int i = 0; i < n; i++) {
        E[p++] = new long[] { n, i, A[i] };
    }
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            E[p++] = new long[] { i, j, (Math.abs(C[i][0] - C[j][0]) + Math.abs(C[i][1] - C[j][1])) * (B[i] + B[j]) };
        }
    }
    ArrayList<Integer> ret1 = new ArrayList<>();
    ArrayList<int[]> ret2 = new ArrayList<>();
    long sum = 0;
    Arrays.sort(E, new Comparator<long[]>() {

        public int compare(long[] a1, long[] a2) {
            // return (int)(a1[2]-a2[2]);
            if (a1[2] > a2[2]) {
                return 1;
            } else if (a1[2] < a2[2]) {
                return -1;
            } else {
                return 0;
            }
        }
    });
    for (int i = 0; i < E.length; i++) {
        int s = (int) E[i][0], e = (int) E[i][1];
        if (!union(s, e)) {
            sum += E[i][2];
            if (s == n)
                ret1.add(e + 1);
            else {
                ret2.add(new int[] { s + 1, e + 1 });
            }
        }
    }
    out.println(sum);
    out.println(ret1.size());
    for (int a : ret1) {
        out.print(a + " ");
    }
    out.println();
    out.println(ret2.size());
    for (int[] a : ret2) {
        out.println(a[0] + " " + a[1]);
    }
}