public String nextString() throws Exception {
    StringBuffer sb = new StringBuffer("");
    byte c = read();
    while (c <= ' ') {
        c = read();
    }
    do {
        sb.append((char) c);
        c = read();
    } while (c > ' ');
    return sb.toString();
}