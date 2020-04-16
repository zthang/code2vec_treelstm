public char nextChar() {
    if (s == null || charIdx >= s.length()) {
        if (st == null || !st.hasMoreTokens())
            try {
                readLine();
            } catch (Exception e) {
            }
        s = st.nextToken();
        charIdx = 0;
    }
    return s.charAt(charIdx++);
}