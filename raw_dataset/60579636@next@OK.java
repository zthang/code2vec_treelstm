String next() throws Exception {
    while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
    return st.nextToken();
}