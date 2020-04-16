void readNextLine() throws IOException {
    last = bf.readLine();
    if (last == null)
        last = "";
    st = new StringTokenizer(last);
}