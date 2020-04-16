void close() throws IOException {
    pw.flush();
    pw.close();
    br.close();
}