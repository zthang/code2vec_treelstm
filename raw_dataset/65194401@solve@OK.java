public void solve(int testNumber, InputReader in, PrintWriter out) {
    int N = in.nextInt();
    int M = in.nextInt();
    DisjointSet dis = new DisjointSet(N);
    for (int i = 0; i < M; i++) {
        int a = in.nextInt() - 1;
        int b = in.nextInt() - 1;
        dis.merge(a, b);
    }
    dis.res = 0;
    boolean[] visited = new boolean[N];
    ArrayList<State> seg = new ArrayList<>();
    for (int i = 0; i < N; i++) {
        if (visited[dis.find(i)] != true) {
            visited[dis.find(i)] = true;
            seg.add(new State(false, dis.getMin(i), dis.find(i)));
            seg.add(new State(true, dis.getMax(i), dis.find(i)));
        }
    }
    Collections.sort(seg, new Comparator<State>() {

        public int compare(State o1, State o2) {
            return Integer.compare(o1.val, o2.val);
        }
    });
    HashSet<Integer> seen = new HashSet<>();
    seen.add(seg.get(0).id);
    int last = 0;
    for (int i = 1; i < seg.size(); i++) {
        if (seen.contains(seg.get(i).id)) {
            seen.remove(seg.get(i).id);
        } else {
            seen.add(seg.get(i).id);
        }
        if (seen.size() == 0) {
            for (int j = last; j <= i; j++) {
                dis.merge(seg.get(last).id, seg.get(j).id);
            }
            last = i + 1;
        }
    }
    out.println(dis.res);
}