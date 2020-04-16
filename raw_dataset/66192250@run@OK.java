static void run() {
    int n = in.nextInt();
    DisjointUnionSets ds = new DisjointUnionSets(26);
    boolean[] seen = new boolean[26];
    while (n-- > 0) {
        char[] str = in.nextCharMap(1)[0];
        for (char c : str) {
            seen[c - 'a'] = true;
        }
        for (int i = 1; i < str.length; i++) {
            ds.union(str[i] - 'a', str[0] - 'a');
        }
    }
    Set<Integer> parents = new HashSet<>();
    for (int i = 0; i < seen.length; i++) {
        if (seen[i]) {
            parents.add(ds.find(i));
        }
    }
    System.out.println(parents.size());
}