String nextString() {
    while (st == null || !st.hasMoreTokens()) {
        try {
            st = new StringTokenizer(reader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    return st.nextToken();
}