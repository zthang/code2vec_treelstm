void solve() {
    int N = ni();
    int[][] dist = new int[N][];
    for (int i = 0; i < N; i++) {
        dist[i] = new int[] { ni(), 2 * i };
    }
    Arrays.sort(dist, new Comparator<int[]>() {

        public int compare(int[] o1, int[] o2) {
            return o2[0] - o1[0];
        }
    });
    List<Integer> l = new ArrayList<Integer>();
    for (int i = 0; i < N; i++) l.add(dist[i][1]);
    for (int i = 0; i < N - 1; i++) out.println((dist[i][1] + 1) + " " + (dist[i + 1][1] + 1));
    for (int i = 0; i < N; i++) {
        int j = i + dist[i][0] - 1;
        // tr(l, i, j)
        out.println((l.get(j) + 1) + " " + (dist[i][1] + 2));
        if (j == l.size() - 1)
            l.add((dist[i][1] + 1));
    }
// for (int )
}