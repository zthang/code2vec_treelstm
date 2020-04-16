public void solve(int testNumber, Scanner sc, PrintWriter pw) {
    int n = sc.nextInt();
    int[] count = new int[26];
    PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {

        public int compare(String s, String t1) {
            int c = 0, c1 = 0;
            HashSet<Character> tmp = new HashSet<>(), tmp2 = new HashSet<>();
            for (int i = 0; i < s.length(); i++) tmp.add(s.charAt(i));
            for (int i = 0; i < t1.length(); i++) tmp2.add(t1.charAt(i));
            for (char x : tmp) c += count[x - 'a'];
            for (char y : tmp2) c1 += count[y - 'a'];
            return c1 - c;
        }
    });
    DSecretPasswords.UnionFind dsu = new DSecretPasswords.UnionFind(28);
    for (int i = 0; i < n; i++) {
        String s = sc.next();
        for (int j = 0; j < s.length(); j++) count[s.charAt(j) - 'a']++;
        pq.add(s);
    }
    int ans = 0;
    while (!pq.isEmpty()) {
        String tmp = pq.poll();
        boolean addOne = true;
        for (int i = 0; i < tmp.length(); i++) if (dsu.isSameSet(tmp.charAt(i) - 'a', 27)) {
            addOne = false;
            break;
        }
        if (addOne)
            ans++;
        for (int i = 0; i < tmp.length(); i++) {
            dsu.unionSet(tmp.charAt(i) - 'a', 27);
            count[tmp.charAt(i) - 'a'] = 0;
        }
    }
    pw.println(ans);
}