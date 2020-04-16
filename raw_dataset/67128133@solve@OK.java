public void solve(int testNumber, InputReader in, PrintWriter out) {
    int N = in.nextInt();
    ArrayList<long[]> bal = new ArrayList<>();
    int M = in.nextInt();
    for (int i = 0; i < N; i++) {
        bal.add(new long[] { 0, i });
    }
    for (int i = 0; i < M; i++) {
        int a = in.nextInt() - 1;
        int b = in.nextInt() - 1;
        int c = in.nextInt();
        bal.get(a)[0] -= c;
        bal.get(b)[0] += c;
    }
    Collections.sort(bal, new Comparator<long[]>() {

        public int compare(long[] o1, long[] o2) {
            return Long.compare(o1[0], o2[0]);
        }
    });
    int pos = N;
    int cur = 0;
    for (int i = 0; i < N; i++) {
        if (bal.get(i)[0] > 0) {
            pos = i;
            break;
        }
    }
    ArrayList<String> res = new ArrayList<>();
    while (pos < N) {
        res.add((bal.get(cur)[1] + 1) + " " + (bal.get(pos)[1] + 1) + " " + Math.min(-bal.get(cur)[0], bal.get(pos)[0]));
        if (-bal.get(cur)[0] > bal.get(pos)[0]) {
            bal.get(cur)[0] += bal.get(pos)[0];
            pos++;
        } else if (-bal.get(cur)[0] < bal.get(pos)[0]) {
            bal.get(pos)[0] += bal.get(cur)[0];
            cur++;
        } else {
            pos++;
            cur++;
        }
    }
    out.println(res.size());
    for (String s : res) {
        out.println(s);
    }
}