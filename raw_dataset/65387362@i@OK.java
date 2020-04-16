static int i() throws IOException {
    if (!st.hasMoreTokens())
        st = new StringTokenizer(br.readLine());
    return Integer.parseInt(st.nextToken());
}