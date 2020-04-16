public void flush() {
    pw.print(buf);
    pw.flush();
    buf.setLength(0);
}