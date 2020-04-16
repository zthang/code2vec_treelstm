void work() {
    int n = in.nextInt();
    int[][] A = new int[n][];
    id = new int[n];
    for (int i = 0; i < n; i++) id[i] = i;
    for (int i = 0; i < n; i++) {
        A[i] = new int[] { in.nextInt(), in.nextInt() };
    }
    Arrays.sort(A, new Comparator<int[]>() {

        public int compare(int[] a1, int[] a2) {
            return a1[0] - a2[0];
        }
    });
    TreeSet<int[]> set = new TreeSet<>(new Comparator<int[]>() {

        public int compare(int[] a1, int[] a2) {
            return a1[0] - a2[0];
        }
    });
    for (int i = 0; i < n; i++) {
        int[] cur = set.higher(A[i]);
        while (cur != null && cur[0] < A[i][1]) {
            if (!union(i, cur[1])) {
                out.println("NO");
                return;
            }
            cur = set.higher(cur);
        }
        set.add(new int[] { A[i][1], i });
    }
    int c = 0;
    for (int i = 0; i < n; i++) {
        if (id[i] == i)
            c++;
    }
    if (c != 1) {
        out.println("NO");
        return;
    }
    out.println("YES");
}