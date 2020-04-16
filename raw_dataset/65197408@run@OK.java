@Override
public void run() {
    try {
        if (ONLINE_JUDGE || !new File("input.txt").exists()) {
            reader = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
        } else {
            reader = new BufferedReader(new FileReader("input.txt"));
            out = new PrintWriter("output.txt");
        }
        solve();
    } catch (IOException e) {
        throw new RuntimeException(e);
    } finally {
        try {
            reader.close();
        } catch (IOException e) {
        // nothinga
        }
        out.close();
    }
}