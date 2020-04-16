@SuppressWarnings("unchecked")
public void solve() {
    int n = in.nextInt();
    to = new ArrayList[n];
    for (int i = 0; i < to.length; i++) {
        to[i] = new ArrayList<>();
    }
    c = new int[n];
    a = new int[n];
    sz = new int[n];
    for (int i = 1; i <= n; i++) {
        number.add(i);
    }
    for (int i = 0; i < n; i++) {
        int from = in.nextInt() - 1;
        if (from < 0) {
            root = i;
        } else {
            to[from].add(i);
        }
        c[i] = in.nextInt();
    }
    dfsSz(root);
    if (dfs(root)) {
        out.println("YES");
        for (int i = 0; i < a.length; i++) {
            out.print(a[i] + " ");
        }
    } else {
        out.println("NO");
    }
}