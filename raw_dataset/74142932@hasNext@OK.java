/**
 * Note:
 * CAN MODIFY the BufferedReader's location and the string tokenizer!!!
 * Recommended to only use with next().
 */
public boolean hasNext() throws IOException {
    while (st == null || !st.hasMoreTokens()) {
        String s = br.readLine();
        if (s == null)
            return false;
        st = new StringTokenizer(s);
    }
    return true;
}