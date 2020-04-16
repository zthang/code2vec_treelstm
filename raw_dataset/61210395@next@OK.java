public String next() {
    while (st == null || !st.hasMoreTokens()) {
        try {
            st = new StringTokenizer(br.readLine());
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
    return st.nextToken();
}