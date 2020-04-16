public void solve(int testNumber, InputReader c, OutputWriter w) {
    int n = c.readInt();
    ArrayList<HashSet<Character>> hs = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        HashSet<Character> te = new HashSet<>();
        char[] s = c.readString().toCharArray();
        for (int j = 0; j < s.length; j++) {
            te.add(s[j]);
        }
        hs.add(te);
    }
    UnionFind dsu = new UnionFind(n);
    for (int i = 0; i < 26; i++) {
        ArrayList<Integer> ar = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            if (hs.get(j).contains((char) ('a' + i))) {
                ar.add(j);
            }
        }
        // w.printLine(ar);
        for (int j = 1; j < ar.size(); j++) {
            dsu.unify(ar.get(0), ar.get(j));
        }
    }
    w.printLine(dsu.components());
}