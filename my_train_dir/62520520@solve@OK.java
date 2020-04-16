private void solve() throws IOException {
    n = reader.nextInt();
    for (int i = 0; i < n; i++) list[i] = new ArrayList<>();
    for (int i = 0; i < 3; i++) {
        c[i] = reader.readIntArray(n);
    }
    for (int i = 0; i < n - 1; i++) {
        int a = reader.nextInt();
        a--;
        int b = reader.nextInt();
        b--;
        list[a].add(b);
        list[b].add(a);
    }
    for (int i = 0; i < n; i++) {
        if (list[i].size() > 2) {
            writer.println("-1");
            return;
        }
        if (list[i].size() == 1)
            st = i;
    }
    int[] a = { 0, 1, 2 };
    generate(0, 2, a);
    writer.println(min);
    for (int i = 0; i < n; i++) writer.print((ans[i] + 1) + " ");
    writer.println();
}