public void solve(int testNumber, InputReader in, PrintWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    ArrayList<Integer>[] a = new ArrayList[n + 1];
    for (int i = 1; i <= n; i++) a[i] = new ArrayList<Integer>();
    for (int i = 0; i < m; i++) {
        int x = in.nextInt();
        int y = in.nextInt();
        // if(x<y)
        a[x].add(y);
        // else
        a[y].add(x);
    }
    TreeSet<Integer> one = new TreeSet<>();
    TreeSet<Integer> two = new TreeSet<>();
    TreeSet<Integer> three = new TreeSet<>();
    for (int i = 1; i <= n; i++) {
        one.add(i);
    }
    for (int i = 1; i <= n; i++) {
        for (int j = 0; j < a[i].size(); j++) {
            int u = i;
            int v = a[i].get(j);
            if (one.contains(u) && one.contains(v)) {
                one.remove(v);
                two.add(v);
            } else if (two.contains(u) && two.contains(v)) {
                two.remove(v);
                three.add(v);
            } else if (three.contains(u) && three.contains(v)) {
                out.println(-1);
                return;
            }
        }
    }
    if (one.size() * two.size() + one.size() * three.size() + two.size() * three.size() != m) {
        out.println(-1);
        return;
    }
    if (three.size() == 0 || two.size() == 0) {
        out.println(-1);
        return;
    }
    for (int i = 1; i <= n; i++) {
        if (one.contains(i)) {
            out.print(1 + " ");
        } else if (two.contains(i)) {
            out.print(2 + " ");
        } else {
            out.print(3 + " ");
        }
    }
}