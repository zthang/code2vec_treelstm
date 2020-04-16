<T> void commit() throws IOException {
    bw.write(sb.toString());
    bw.flush();
    sb = new StringBuilder();
}