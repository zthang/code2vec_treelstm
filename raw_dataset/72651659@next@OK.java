String next() throws Exception {
    while (st == null || !st.hasMoreElements()) {
        try {
            st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
            throw new Exception(e.toString());
        }
    }
    return st.nextToken();
}