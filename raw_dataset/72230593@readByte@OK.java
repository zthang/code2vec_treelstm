// private int ni() {
// return Integer.parseInt(scanner.next());
// }
// private byte[] inbuf = new byte[1024];
// public int lenbuf = 0, ptrbuf = 0;
private int readByte() {
    if (lenbuf == -1)
        throw new InputMismatchException();
    if (ptrbuf >= lenbuf) {
        ptrbuf = 0;
        try {
            lenbuf = is.read(inbuf);
        } catch (IOException e) {
            throw new InputMismatchException();
        }
        if (lenbuf <= 0)
            return -1;
    }
    return inbuf[ptrbuf++];
}