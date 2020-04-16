/**
 * Skips a line. Sets st to null if has tokens left, and otherwise
 * reads a line.
 */
public void skipLine() throws IOException {
    if (st == null || !st.hasMoreTokens()) {
        // Otherwise, would do nothing.
        br.readLine();
    }
    st = null;
}