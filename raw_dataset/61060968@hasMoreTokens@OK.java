public boolean hasMoreTokens() {
    while (st == null || !st.hasMoreElements()) {
        String line = null;
        try {
            line = br.readLine();
        } catch (IOException e) {
            return false;
        }
        if (line == null) {
            return false;
        }
        st = new StringTokenizer(line);
    }
    return true;
}