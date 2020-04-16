static double d() throws IOException {
    if (!st.hasMoreTokens())
        st = new StringTokenizer(br.readLine());
    return Double.parseDouble(st.nextToken());
}