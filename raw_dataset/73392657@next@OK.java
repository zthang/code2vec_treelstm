String next() {
    while (st == null || !st.hasMoreTokens()) {
        try {
            st = new StringTokenizer(br.readLine());
        } catch (Exception r) {
            r.printStackTrace();
        }
    }
    return st.nextToken();
}