// ************* Code ends here ***************
void init() throws Exception {
    // Scanner in;
    InputReader in;
    PrintWriter w;
    boolean online = false;
    String common_in_fileName = "\\Samplein";
    String common_out_fileName = "\\in";
    int test_files = 0;
    for (int file_no = 0; file_no <= test_files; file_no++) {
        String x = "" + file_no;
        if (x.length() == 1)
            x = "0" + x;
        // + "" + x;
        String in_fileName = common_in_fileName;
        String out_fileName = common_out_fileName + "" + x;
        if (online) {
            // in = new Scanner(new File(in_fileName + ".txt"));
            in = new InputReader(new FileInputStream(new File(in_fileName + ".txt")));
            w = new PrintWriter(new FileWriter(out_fileName + ".txt"));
        } else {
            // in = new Scanner(System.in);
            in = new InputReader(System.in);
            w = new PrintWriter(System.out);
        }
        solve(in, w);
        w.close();
    }
}