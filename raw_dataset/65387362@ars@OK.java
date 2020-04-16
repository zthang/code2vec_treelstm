static String[] ars(int n) throws IOException {
    String[] ar = new String[n];
    st = new StringTokenizer(br.readLine());
    for (int x = 0; x < n; x++) ar[x] = st.nextToken();
    return ar;
}