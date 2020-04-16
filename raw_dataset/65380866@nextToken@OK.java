String nextToken() throws IOException {
    while (!st.hasMoreTokens()) {
        readNextLine();
    }
    return st.nextToken();
}