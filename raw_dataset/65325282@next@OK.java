public String next() {
    while (!st.hasMoreTokens()) {
        try {
            st = new StringTokenizer(r.readLine());
        } catch (Exception e) {
        }
    }
    return st.nextToken();
}