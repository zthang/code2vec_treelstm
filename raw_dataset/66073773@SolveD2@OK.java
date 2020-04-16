public static void SolveD2() {
    Scanner sc = new Scanner(System.in);
    pw = new PrintWriter(new BufferedOutputStream(System.out));
    int n = sc.nextInt();
    // 0 .. n-1 are the password, Last 26 are alphbets
    ArrayList<Integer>[] ac = new ArrayList[n + 26];
    boolean[] used = new boolean[n + 26];
    for (int i = 0; i < n + 26; i++) ac[i] = new ArrayList();
    for (int i = 0; i < n; i++) {
        // one line of password
        char[] oneline = sc.next().toCharArray();
        for (int j = 0; j < oneline.length; j++) {
            int curri = n + oneline[j] - 'a';
            ac[curri].add(i);
            ac[i].add(curri);
        }
    }
    int total = 0;
    for (int i = n; i < n + 26; i++) {
        if (ac[i].size() != 0 && !used[i]) {
            total++;
            dfs(i, used, ac);
        }
    }
    pw.println(total);
    pw.close();
}