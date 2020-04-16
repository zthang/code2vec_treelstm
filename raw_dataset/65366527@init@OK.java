/**
 * call this method to initialize reader for InputStream
 */
static void init(InputStream input) {
    reader = new BufferedReader(new InputStreamReader(input));
    tokenizer = new StringTokenizer("");
}