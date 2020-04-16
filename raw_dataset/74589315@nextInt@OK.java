static int nextInt() throws IOException {
    while (zer == null || !zer.hasMoreTokens()) zer = new StringTokenizer(br.readLine());
    return Integer.parseInt(zer.nextToken());
}