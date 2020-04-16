boolean query(int i, FastReader s, PrintWriter w) {
    w.println("? " + ++i);
    w.flush();
    return s.nextChar() == 'Y';
}