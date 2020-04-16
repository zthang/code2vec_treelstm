void solve() {
    int n = ni();
    int[] a = na(n);
    int[][] ai = new int[n][];
    for (int i = 0; i < n; i++) {
        ai[i] = new int[] { a[i], i };
    }
    Arrays.sort(ai, new Comparator<int[]>() {

        public int compare(int[] a, int[] b) {
            return a[0] - b[0];
        }
    });
    int max = ai[n - 1][0];
    int arg = ai[n - 1][1];
    int[] row = new int[n + 1];
    List<List<int[]>> unders = new ArrayList<>();
    for (int i = 0; i <= n; i++) unders.add(new ArrayList<>());
    Arrays.fill(row, -1);
    row[0] = 2 * arg + 1;
    row[max] = 2 * arg + 2;
    int p = 1;
    if (p == max)
        p++;
    for (int i = n - 2; i >= 0; i--) {
        row[p] = 2 * ai[i][1] + 1;
        if (p < max) {
            if (p + ai[i][0] - 1 <= max) {
                unders.get(p + ai[i][0] - 1).add(new int[] { 2 * ai[i][1] + 2, 1 });
            } else {
                unders.get(max).add(new int[] { 2 * ai[i][1] + 2, p + ai[i][0] - max });
            }
        } else if (p > max) {
            if (p - ai[i][0] + 1 >= max) {
                unders.get(p - ai[i][0] + 1).add(new int[] { 2 * ai[i][1] + 2, 1 });
            } else {
                unders.get(max).add(new int[] { 2 * ai[i][1] + 2, ai[i][0] + max - p });
            }
        }
        p++;
        if (p == max)
            p++;
    }
    for (int i = 0; i < p - 1; i++) {
        out.println(row[i] + " " + row[i + 1]);
    }
    for (int i = 0; i < p; i++) {
        if (i != max) {
            for (int[] x : unders.get(i)) {
                out.println(row[i] + " " + x[0]);
            }
        }
    }
    Collections.sort(unders.get(max), new Comparator<int[]>() {

        public int compare(int[] a, int[] b) {
            return a[1] - b[1];
        }
    });
    List<int[]> um = unders.get(max);
    int prev = row[max];
    for (int i = 0; i < um.size(); ) {
        int j = i;
        while (j < um.size() && um.get(j)[1] == um.get(i)[1]) j++;
        for (int k = i; k < j; k++) {
            out.println(prev + " " + um.get(k)[0]);
        }
        prev = um.get(i)[0];
        i = j;
    }
}