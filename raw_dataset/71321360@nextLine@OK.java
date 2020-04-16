/**
 * This will set st to null, and this ignores current line
 */
public String[] nextLine() throws IOException {
    String s = br.readLine();
    if (s == null)
        return null;
    st = new StringTokenizer(s);
    ArrayList<String> result = new ArrayList<>();
    while (st.hasMoreTokens()) {
        result.add(st.nextToken());
    }
    st = null;
    return result.toArray(new String[0]);
}