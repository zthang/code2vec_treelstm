private static void solve() throws IOException {
    n = enter.nextInt();
    int m = enter.nextInt();
    vert = new LinkedList[n + 1];
    for (int i = 0; i < n + 1; i++) {
        vert[i] = new LinkedList<>();
    }
    for (int i = 0; i < m; i++) {
        int a = enter.nextInt();
        int b = enter.nextInt();
        vert[a].addLast(b);
    }
    recursion(1);
    out.println(max);
}