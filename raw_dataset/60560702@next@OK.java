public String next() {
    while (st == null || !st.hasMoreElements()) {
        String line = null;
        try {
            line = br.readLine();
        } catch (IOException e) {
        }
        st = new StringTokenizer(line);
    }
    return st.nextToken();
}