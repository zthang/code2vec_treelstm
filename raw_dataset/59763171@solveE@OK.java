private void solveE() throws IOException {
    int n = in.nextInt();
    TreeSet<String> blocked = new TreeSet<>();
    for (int i = 0; i < 2; i++) blocked.add(in.next());
    out.println("YES");
    if (!blocked.contains("ab") && !blocked.contains("bc") && !blocked.contains("ca")) {
        while (n-- > 0) out.print("abc");
    } else if (!blocked.contains("ac") && !blocked.contains("cb") && !blocked.contains("ba")) {
        while (n-- > 0) out.print("acb");
    } else {
        if (blocked.contains("ab")) {
            for (int i = 0; i < n; i++) out.print('b');
            for (int i = 0; i < n; i++) out.print('c');
            for (int i = 0; i < n; i++) out.print('a');
        } else if (blocked.contains("bc")) {
            for (int i = 0; i < n; i++) out.print('c');
            for (int i = 0; i < n; i++) out.print('a');
            for (int i = 0; i < n; i++) out.print('b');
        } else {
            // blocked.contains("ca")
            for (int i = 0; i < n; i++) out.print('a');
            for (int i = 0; i < n; i++) out.print('b');
            for (int i = 0; i < n; i++) out.print('c');
        }
    }
}