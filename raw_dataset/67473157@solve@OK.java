public void solve(int testNumber, InputReader in, PrintWriter out) {
    int n = in.nextInt();
    parent = new int[26];
    values = new boolean[26][26];
    for (int i = 0; i < 26; i++) makeSet(i);
    HashSet<Character> letters = new HashSet<Character>();
    for (int i = 0; i < n; i++) {
        String s = in.next();
        for (int j = 0; j < s.length(); j++) {
            unionSets(s.charAt(0) - 'a', s.charAt(j) - 'a');
        }
        letters.add(s.charAt(0));
    }
    HashSet<Integer> dif = new HashSet<Integer>();
    for (char c = 'a'; c <= 'z'; c++) {
        if (letters.contains(c)) {
            dif.add(parent[c - 'a']);
        }
    }
    out.println(dif.size());
// for (int i = 0 ; i < 26 ; i++) out.println((char)(i + 'a') + " " + parent[i]);
}