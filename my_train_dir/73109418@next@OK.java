String next() {
    while (st == null || !st.hasMoreElements()) {
        try {
            st = new StringTokenizer(br.readLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    return st.nextToken();
}