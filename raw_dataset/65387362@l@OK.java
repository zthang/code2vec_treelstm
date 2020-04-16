static long l() throws IOException {
    if (!st.hasMoreTokens())
        st = new StringTokenizer(br.readLine());
    return Long.parseLong(st.nextToken());
}