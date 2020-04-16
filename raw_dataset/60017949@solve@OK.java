public void solve(int testNumber, ScanReader in, PrintWriter out) {
    int n = in.scanInt();
    int[][] di = new int[n][2];
    for (int i = 0; i < n; i++) {
        di[i][0] = in.scanInt();
        di[i][1] = i + 1;
    }
    Arrays.sort(di, new Comparator<int[]>() {

        public int compare(int[] o1, int[] o2) {
            return -o1[0] + o2[0];
        }
    });
    ArrayList<int[]> ans = new ArrayList<>();
    int[] array = new int[2 * 100010];
    int counter = 0;
    for (int i = 0; i < n; i++) {
        array[counter++] = 2 * di[i][1] - 1;
        if (i != 0)
            ans.add(new int[] { array[(i - 1)], array[i] });
    }
    int dist = n;
    for (int i = 0; i < n; i++, dist--) {
        if (di[i][0] == dist) {
            array[counter++] = di[i][1] * 2;
            ans.add(new int[] { array[counter - 2], array[counter - 1] });
            dist++;
        } else {
            ans.add(new int[] { array[counter - (dist - di[i][0]) - 1], di[i][1] * 2 });
        }
    }
    for (int[] p : ans) out.println(p[0] + " " + p[1]);
}