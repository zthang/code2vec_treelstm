public void solve(int testNumber, InputReader in, PrintWriter out) {
    int T = in.nextInt();
    for (int iter = 0; iter < T; iter++) {
        int N = in.nextInt();
        int M = in.nextInt();
        ArrayList<cost> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            arr.add(new cost(i, in.nextInt()));
        }
        Collections.sort(arr, new Comparator<cost>() {

            public int compare(cost cost, cost t1) {
                return Integer.compare(cost.val, t1.val);
            }
        });
        int sum = 0;
        if (M < N || N == 2) {
            out.println(-1);
        } else {
            for (int i = 0; i < N; i += 1) {
                sum += 2 * arr.get(i).val;
            }
            for (int i = N; i < M; i++) {
                sum += arr.get(0).val + arr.get(1).val;
            }
            out.println(sum);
            for (int i = 0; i < N; i++) {
                out.println((i + 1) + " " + ((i + 2) > N ? 1 : (i + 2)));
            }
            for (int i = N; i < M; i++) {
                out.println(arr.get(1).id + 1 + " " + (arr.get(0).id + 1));
            }
        }
    }
}