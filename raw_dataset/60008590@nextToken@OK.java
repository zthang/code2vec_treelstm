String nextToken() throws IOException {
    while (st == null || !st.hasMoreTokens()) {
        String s = reader.readLine();
        if (s == null)
            return null;
        st = new StringTokenizer(s);
    }
    return st.nextToken();
}