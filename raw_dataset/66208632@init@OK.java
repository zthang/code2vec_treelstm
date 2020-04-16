private static void init(int[] weights, BufferedReader br) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < weights.length; i++) {
        weights[i] = Integer.parseInt(st.nextToken());
    }
}