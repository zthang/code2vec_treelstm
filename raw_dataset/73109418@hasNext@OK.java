boolean hasNext() {
    if (st.hasMoreElements())
        return true;
    try {
        st = new StringTokenizer(br.readLine());
    } catch (IOException e) {
        e.printStackTrace();
    }
    return st.hasMoreTokens();
}