public String nli() {
    String line = "";
    if (st.hasMoreTokens())
        line = st.nextToken();
    else
        try {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    while (st.hasMoreTokens()) line += " " + st.nextToken();
    return line;
}