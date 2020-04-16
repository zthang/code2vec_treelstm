public static String next() throws Throwable {
    int i = 0;
    while (i < 33 && i != -1) i = System.in.read();
    int cptr = 0;
    while (i >= 33) {
        in[cptr++] = (char) i;
        i = System.in.read();
    }
    return new String(in, 0, cptr);
}