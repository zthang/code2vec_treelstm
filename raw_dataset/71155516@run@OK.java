@Override
public void run() {
    InputReader in = new InputReader(System.in);
    PrintWriter w = new PrintWriter(System.out);
    // Scanner has functions to read ints, longs, strings, chars, etc.
    int q = Integer.parseInt(in.nextLine());
    for (int i = 0; i < q; i++) {
        String s = in.nextLine();
        getRes(w, s);
    }
    w.flush();
    w.close();
}