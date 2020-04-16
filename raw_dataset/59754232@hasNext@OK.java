boolean hasNext() throws IOException {
    return br.ready() || (st != null && st.hasMoreTokens());
}