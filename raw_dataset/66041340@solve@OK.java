void solve() {
    Set<String> st = new HashSet<>();
    int id = 0;
    int n = ni();
    List<Integer>[] d = new List[26];
    for (int i = 0; i < 26; ++i) {
        d[i] = new ArrayList<>();
    }
    for (int i = 0; i < n; ++i) {
        String s = ns();
        if (st.contains(s))
            continue;
        st.add(s);
        for (char a : s.toCharArray()) {
            d[a - 'a'].add(id);
        }
        id++;
    }
    init(id);
    for (int i = 0; i < 26; ++i) {
        for (int j = 1, len = d[i].size(); j < len; ++j) {
            combine(d[i].get(j), d[i].get(j - 1));
        }
    }
    println(groups);
}