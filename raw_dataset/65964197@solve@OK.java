public void solve(int testNumber, InputReader in, PrintWriter out) {
    this.out = out;
    this.in = in;
    boolean[] is_there = new boolean[26];
    DSU ob = new DSU(26);
    int i = 0;
    int n = ni();
    for (i = 0; i < n; i++) {
        String st = n();
        for (int j = 0; j < st.length() - 1; j++) {
            ob.unite(st.charAt(j) - 'a', st.charAt(j + 1) - 'a');
        }
        for (int j = 0; j < st.length(); j++) is_there[st.charAt(j) - 'a'] = true;
    }
    HashSet<Integer> hset = new HashSet<>();
    for (i = 0; i < 26; i++) {
        if (is_there[i])
            hset.add(ob.find(i));
    }
    pn(hset.size());
}