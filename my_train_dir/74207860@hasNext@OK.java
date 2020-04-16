public boolean hasNext() {
    try {
        if (!st.hasMoreTokens() && !br.ready())
            return false;
        else
            return true;
    } catch (Exception e) {
        e.printStackTrace();
    }
    return false;
}