public void solve(PrintWriter pw) throws IOException {
    FastReader sc = new FastReader();
    int n = sc.nextInt();
    String[] s = new String[n + 1];
    ArrayList<Integer>[] a = new ArrayList[26];
    for (int i = 0; i < 26; i++) {
        a[i] = new ArrayList();
    }
    for (int i = 1; i <= n; i++) {
        s[i] = sc.next();
        for (int j = 0; j < s[i].length(); j++) {
            a[s[i].charAt(j) - 'a'].add(i);
        }
    }
    int[] parent = new int[n + 1], size = new int[n + 1];
    for (int i = 1; i <= n; i++) {
        parent[i] = i;
        size[i] = 1;
    }
    for (int j = 0; j < 26; j++) {
        if (a[j].isEmpty()) {
            continue;
        }
        int x = a[j].get(0);
        for (int i = 1; i < a[j].size(); i++) {
            merge(x, a[j].get(i), parent, size);
        }
    }
    int e = 0;
    for (int i = 1; i <= n; i++) {
        if (parent[i] == i) {
            ++e;
        }
    }
    pw.println(e);
}