private static void execute(ContestReader reader, PrintWriter out) {
    int t = reader.nextInt();
    for (int i = 0; i < t; i++) {
        int n = reader.nextInt();
        int m = reader.nextInt();
        int[] as = reader.nextInt(n);
        for (String line : solve(n, m, as)) {
            out.println(line);
        }
    }
}