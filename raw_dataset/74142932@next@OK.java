public String next() throws IOException {
    while (st == null || !st.hasMoreTokens()) {
        String s = br.readLine();
        if (s == null)
            return null;
        st = new StringTokenizer(s);
    }
    return st.nextToken();
}