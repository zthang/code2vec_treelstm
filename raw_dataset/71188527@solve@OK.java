public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    String q = in.next();
    StringBuilder reversed = new StringBuilder(StringUtils.reversed(q));
    for (int i = 0; i < reversed.length(); i++) {
        char c = reversed.charAt(i);
        reversed.setCharAt(i, c == '<' ? '>' : '<');
    }
    int[] result = solveForInstance(n, reversed.toString());
    ArrayUtils.reverse(result, 0, result.length - 1);
    out.println(result);
    out.println(solveForInstance(n, q));
}