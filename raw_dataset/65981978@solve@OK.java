static void solve() throws IOException {
    int n = nextInt();
    parent = new int[n + 1];
    rank = new int[n + 1];
    ArrayList<HashSet<Integer>> list = new ArrayList<HashSet<Integer>>();
    for (int i = 0; i <= 25; i++) list.add(new HashSet<Integer>());
    for (int i = 1; i <= n; i++) {
        String s = nextLine();
        for (int j = 0; j < s.length(); j++) list.get(s.charAt(j) - 'a').add(i);
    }
    for (int i = 1; i <= n; i++) makeset(i);
    for (int i = 0; i <= 25; i++) {
        int y = -1;
        for (int j : list.get(i)) {
            if (y == -1)
                y = j;
            else {
                union(y, j);
            }
        }
    }
    HashSet<Integer> ans = new HashSet<>();
    for (int i = 1; i <= n; i++) {
        ans.add(find(i));
    }
    out.println(ans.size());
}