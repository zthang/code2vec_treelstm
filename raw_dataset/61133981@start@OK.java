public void start() throws IOException {
    fs = new FScanner(new InputStreamReader(System.in));
    // reader = new FScanner(new FileReader("input"));
    // pw = new PrintWriter("input.txt");
    pw = new PrintWriter(System.out);
    int n = fs.nextInt(), k = fs.nextInt();
    int[][] gr = new int[n][n];
    for (int i = 0; i < k; i++) {
        int a = fs.nextInt() - 1, b = fs.nextInt() - 1;
        gr[a][b] = 1;
        gr[b][a] = 1;
    }
    if (k == 0)
        pw.println(0);
    else {
        int[] c = new int[n];
        Arrays.fill(c, 1);
        c[0] = 0;
        int ans = 0;
        while (up(c)) {
            ans = Math.max(ans, calc(c, gr));
        }
        pw.println(ans);
    }
    pw.close();
}