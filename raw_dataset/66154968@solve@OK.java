public void solve(InputReader sc, PrintWriter out) {
    int n = sc.nextInt();
    // out.println((int)'a');
    int[] parents = new int[26];
    for (int i = 0; i < 26; i++) parents[i] = i;
    boolean[] found = new boolean[26];
    for (int i = 0; i < n; i++) {
        String s = sc.next();
        int first = (int) s.charAt(0) - 97;
        found[first] = true;
        for (int j = 1; j < s.length(); j++) {
            int now = (int) s.charAt(j) - 97;
            parents[now] = parents[first];
            found[now] = true;
        }
    }
    process(parents, found);
    HashSet<Integer> set = new HashSet();
    for (int i : parents) if (found[i])
        set.add(i);
    out.println(set.size());
}