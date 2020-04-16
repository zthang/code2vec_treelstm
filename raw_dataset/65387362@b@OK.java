static boolean b() throws IOException {
    if (!st.hasMoreTokens())
        st = new StringTokenizer(br.readLine());
    return Boolean.parseBoolean(st.nextToken());
}