String nextLine() throws IOException {
    String s = last;
    readNextLine();
    return s;
}