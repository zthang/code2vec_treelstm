public void solve(int testNumber, InputReader in, PrintWriter out) {
    int n = in.nextInt(), m = in.nextInt();
    UnionFind initial = new UnionFind(n);
    for (int i = 0; i < m; i++) {
        int a = in.nextInt() - 1;
        int b = in.nextInt() - 1;
        initial.union(a, b);
    }
    List<List<Integer>> components = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        components.add(new ArrayList<>());
    }
    for (int i = 0; i < n; i++) {
        components.get(initial.rep(i)).add(i);
    }
    List<Pair<Integer, Integer>> intervals = new ArrayList<>();
    for (List<Integer> c : components) {
        if (c.size() <= 1)
            continue;
        intervals.add(Pair.of(c.get(0), c.get(c.size() - 1)));
    }
    intervals.sort(Comparator.comparingInt(i -> i.first));
    int start = -1;
    int end = -1;
    int answer = 0;
    intervals.add(Pair.of(Integer.MAX_VALUE, Integer.MAX_VALUE));
    for (Pair<Integer, Integer> i : intervals) {
        if (i.first <= end) {
            end = Math.max(end, i.second);
        } else {
            if (start >= 0) {
                HashSet<Integer> distinct = new HashSet<>();
                for (int j = start; j <= end; j++) {
                    distinct.add(initial.rep(j));
                }
                answer += distinct.size() - 1;
            }
            start = i.first;
            end = i.second;
        }
    }
    out.println(answer);
}