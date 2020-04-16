String next() {
    while (!st.hasMoreElements()) {
        try {
            st = new StringTokenizer(br.readLine());
        } catch (Exception e) {
        }
    }
    return st.nextToken();
}