boolean ready() throws IOException {
    return bf.ready() || (st != null && st.hasMoreElements());
}