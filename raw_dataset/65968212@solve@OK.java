static void solve() {
    n = in.nextInt();
    a = new ArrayList[26];
    Arrays.setAll(a, i -> new ArrayList<>());
    for (int i = 0; i < n; i++) {
        String s = in.next();
        int[] ch = new int[26];
        for (int j = 0; j < s.length(); j++) {
            ch[s.charAt(j) - 'a'] = 1;
        }
        for (int j = 0; j < 26; j++) {
            if (ch[j] == 1) {
                a[j].add(i);
            }
        }
    }
    DSU dsu = new DSU(n);
    for (int i = 0; i < 26; i++) {
        for (int j = 1; j < a[i].size(); j++) {
            dsu.uniteSets(a[i].get(0), a[i].get(j));
        }
    }
    HashSet<Integer> hs = new HashSet<>();
    for (int i = 0; i < n; i++) {
        hs.add(dsu.findSet(i));
    }
    out.println(hs.size());
}