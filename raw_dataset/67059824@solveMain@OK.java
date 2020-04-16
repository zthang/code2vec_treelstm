void solveMain() {
    int n = in.nextInt();
    UnionFind uf = new UnionFind(26);
    boolean[] visited = new boolean[26];
    for (int i = 0; i < n; i++) {
        char[] s = in.nextStr().toCharArray();
        for (int j = 0; j < s.length; j++) {
            visited[s[j] - 'a'] = true;
            for (int k = 0; k < s.length; k++) {
                uf.union(s[j] - 'a', s[k] - 'a');
            }
        }
    }
    HashSet<Integer> set = new HashSet<>();
    for (int i = 0; i < 26; i++) if (visited[i])
        set.add(uf.find(i));
    out.println(set.size());
}