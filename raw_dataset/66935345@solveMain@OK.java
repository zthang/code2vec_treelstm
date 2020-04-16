void solveMain() {
    int n = in.nextInt(), m = in.nextInt();
    int a = in.nextInt() - 1, b = in.nextInt() - 1;
    ArrayList<ArrayList<Integer>> g = new ArrayList<>();
    for (int i = 0; i < n; i++) g.add(new ArrayList<>());
    for (int i = 0; i < m; i++) {
        int x = in.nextInt() - 1;
        int y = in.nextInt() - 1;
        g.get(x).add(y);
        g.get(y).add(x);
    }
    boolean[] ra = reach(g, a, b), rb = reach(g, b, a);
    long numA = 0, numB = 0;
    for (int i = 0; i < n; i++) {
        if (!rb[i])
            numA++;
        if (!ra[i])
            numB++;
    }
    out.println(numA * numB);
}