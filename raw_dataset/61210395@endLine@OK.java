public boolean endLine() {
    try {
        String next = br.readLine();
        while (next != null && next.trim().isEmpty()) {
            next = br.readLine();
        }
        if (next == null) {
            return true;
        }
        st = new StringTokenizer(next);
        return st.hasMoreTokens();
    } catch (Exception e) {
        throw new RuntimeException();
    }
}