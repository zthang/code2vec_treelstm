void solveOne(InputStream in, PrintWriter pw) {
    Locale.setDefault(Locale.ROOT);
    try (Scanner sc = new Scanner(in)) {
        parse(sc);
    }
    pw.println(solve());
}