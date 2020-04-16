String next() {
    while (st == null || !st.hasMoreElements()) {
        try {
            st = new StringTokenizer(bf.readLine());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    return st.nextToken();
}