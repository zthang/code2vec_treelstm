public void solve(int testNumber, InputReader in, PrintWriter out) {
    int n = in.nextInt();
    HashSet<Character>[] s = new HashSet[n];
    for (int i = 0; i < n; i++) {
        s[i] = new HashSet<>();
        char[] input = in.next().toCharArray();
        for (char x : input) s[i].add(x);
    }
    UnionFind uf = new UnionFind(n);
    List<Integer>[] index = new List[26];
    for (int i = 0; i < 26; i++) index[i] = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        for (char c : s[i]) {
            index[c - 'a'].add(i);
        }
    }
    for (List<Integer> ind : index) {
        for (int i = 0; i + 1 < ind.size(); i++) {
            uf.union(ind.get(i), ind.get(i + 1));
        }
    }
    int answer = 0;
    for (int i = 0; i < n; i++) {
        if (uf.rep(i) == i)
            answer++;
    }
    out.println(answer);
}