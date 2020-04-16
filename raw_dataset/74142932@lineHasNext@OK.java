/**
 * Note:
 * CAN MODIFY the BufferedReader's location and the string tokenizer!!!
 * Recommended to only use with next().
 */
public boolean lineHasNext() throws IOException {
    if (st == null) {
        String s = br.readLine();
        if (s == null)
            return false;
        st = new StringTokenizer(s);
    }
    return st.hasMoreTokens();
}