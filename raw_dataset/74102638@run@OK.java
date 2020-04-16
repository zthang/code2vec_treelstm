// @Suppress("Warning")
public void run() {
    InputReader in = new InputReader(System.in);
    PrintWriter w = new PrintWriter(System.out);
    int t = in.nextInt();
    while (t-- > 0) {
        int n = in.nextInt();
        int i, j, k;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        boolean[] visited = new boolean[n + 10];
        int count = 0;
        ArrayList<Integer> rem = new ArrayList<>();
        for (i = 1; i <= n; i++) {
            boolean f = false;
            boolean test = false;
            k = in.nextInt();
            for (j = 0; j < k; j++) {
                int x = in.nextInt();
                list.get(i).add(x);
                if (!visited[x] && !test) {
                    count++;
                    visited[x] = true;
                    f = true;
                    test = true;
                }
            }
            if (!f) {
                rem.add(i);
            }
        }
        if (count == n) {
            w.println("OPTIMAL");
        } else {
            w.println("IMPROVE");
            w.print(rem.get(0) + " ");
            for (i = 1; i <= n; i++) {
                if (!visited[i]) {
                    w.print(i);
                    break;
                }
            }
            w.println();
        }
    }
    w.flush();
    w.close();
}