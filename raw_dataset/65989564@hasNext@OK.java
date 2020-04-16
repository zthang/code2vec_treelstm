public boolean hasNext() throws IOException {
    if (st != null && st.hasMoreTokens()) {
        return true;
    }
    String s = br.readLine();
    if (s == null || s.isEmpty()) {
        return false;
    }
    st = new StringTokenizer(s);
    return true;
}