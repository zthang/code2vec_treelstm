private void solve(InputReader inp, PrintWriter out) {
    int n = inp.nextInt();
    List<Pair> pairs = new ArrayList<>(n + 1);
    for (int i = 0; i < n; i++) {
        pairs.add(new Pair(inp.nextInt(), 2 + 2 * i));
    }
    Collections.sort(pairs);
    Pair prev = pairs.get(0);
    for (int i = 1; i < n; i++) {
        Pair curr = pairs.get(i);
        out.println(prev.b + " " + curr.b);
        prev = curr;
    }
    for (int i = 0; i < n; i++) {
        int d = pairs.get(i).a - 1, curr = pairs.get(i).b - 1;
        int other = pairs.get(i + d).b;
        out.println(other + " " + curr);
        if (d + i + 1 == pairs.size()) {
            pairs.add(new Pair(0, curr));
        }
    }
}