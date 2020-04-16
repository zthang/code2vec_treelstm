public void solve(int testNumber, FastInput in, FastOutput out) {
    int n = in.readInt();
    int[] a = new int[n + 1];
    MultiWayIntegerStack edges = new MultiWayIntegerStack(n + 1, n);
    for (int i = 1; i <= n; i++) {
        a[i] = in.readInt();
        edges.addLast(i, i - a[i]);
    }
    CircularPath path = new CircularPath(edges);
    IntegerList circle = path.getCircular();
    out.println(circle.size());
    for (int i = 0; i < circle.size(); i++) {
        out.append(circle.get(i)).append(' ');
    }
}