public String next() {
    while (!st.hasMoreTokens()) {
        try {
            st = new StringTokenizer(br.readLine());
        } catch (Exception e) {
            throw null;
        }
    }
    return st.nextToken();
}