public void solve(int testNumber, InputReader in, PrintWriter out) {
    vertices = in.nextInt();
    edgecount = in.nextInt();
    sparse = new int[8][8];
    u = new int[edgecount];
    v = new int[edgecount];
    for (int i = 0; i < edgecount; i++) {
        u[i] = in.nextInt();
        v[i] = in.nextInt();
    }
    getanswer(1);
    out.println(ans);
}