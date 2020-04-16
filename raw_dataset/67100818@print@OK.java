private static void print(Object o, Object... A) {
    String res = build(o, A);
    if (DEBUG == 2)
        err(res, '(', time(), ')');
    if (res.length() > 0)
        pw.println(res);
    if (DEBUG == 1) {
        pw.flush();
        System.out.flush();
    }
}