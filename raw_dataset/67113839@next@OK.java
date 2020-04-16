public String next() throws IOException {
    while (!st.hasMoreTokens()) {
        String line = in.readLine();
        if (line == null) {
            return null;
        }
        st = new StringTokenizer(line);
    }
    return st.nextToken();
}