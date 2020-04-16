public void solve(int testNumber, InputReader in, PrintWriter out) {
    nodecount = in.nextInt();
    int m = in.nextInt();
    for (int i = 0; i < m; i++) {
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        if (n1 > n2) {
            int temp = n1;
            n1 = n2;
            n2 = temp;
        }
        edges.add(new Edge(n1, n2));
    }
    for (int i = 1; i <= 6; i++) dominos.add(Integer.toString(i) + Integer.toString(i));
    for (int i = 1; i <= 6; i++) {
        for (int j = i + 1; j <= 6; j++) {
            dominos.add(Integer.toString(i) + Integer.toString(j));
        }
    }
    recur(new ArrayList<>());
    out.println(maxnumDos);
}