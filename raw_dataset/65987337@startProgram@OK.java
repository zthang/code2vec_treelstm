void startProgram() {
    while (k.hasNext()) {
        int n = k.nextInt();
        set = new HashSet[26];
        for (int i = 0; i < 26; i++) {
            set[i] = new HashSet<Integer>();
        }
        uni = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            char[] s = k.next().toCharArray();
            for (int j = 0; j < s.length; j++) {
                set[s[j] - 'a'].add(i);
            }
        }
        startAlgo();
    }
    z.flush();
    System.exit(0);
}