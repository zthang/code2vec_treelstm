private void m() {
    in = new FastScanner(System.in);
    out = new PrintWriter(System.out);
    /*
        try {
            String path = "input.txt";
            out = new PrintWriter(new BufferedWriter(new FileWriter(new File(path))));
        }catch (IOException e){
            e.printStackTrace();
        }
        */
    solve();
    out.flush();
    in.close();
    out.close();
}