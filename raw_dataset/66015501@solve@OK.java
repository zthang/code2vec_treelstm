public void solve(int testNumber, FastReader s, PrintWriter w) {
    int n = s.nextInt();
    ArrayList<Integer>[] a = new ArrayList[26];
    for (int i = 0; i < 26; i++) a[i] = new ArrayList<>();
    TreeSet<Character> t = new TreeSet<>();
    for (int i = 0; i < n; i++) {
        char[] c = s.next().toCharArray();
        t.clear();
        for (char x : c) t.add(x);
        for (char x : t) a[x - 'a'].add(i);
    }
    dsu d = new dsu(n);
    for (int i = 0; i < 26; i++) {
        for (int j = 1; j < a[i].size(); j++) d.unite(a[i].get(j - 1), a[i].get(j));
    }
    w.println(d.con);
}