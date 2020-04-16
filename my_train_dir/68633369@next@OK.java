String next() {
    while (st == null || !st.hasMoreTokens()) {
        try {
            st = new StringTokenizer(br.readLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    return st.nextToken();
}