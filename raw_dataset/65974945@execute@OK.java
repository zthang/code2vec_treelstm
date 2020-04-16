private static void execute(ContestReader reader, PrintWriter out) {
    int n = reader.nextInt();
    String[] passwords = reader.next(n);
    out.println(solve(n, passwords));
}