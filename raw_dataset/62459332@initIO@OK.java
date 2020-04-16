public void initIO(String inputFile, String outputFile) {
    try {
        in = new FileInputStream(inputFile);
        bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile)));
    } catch (Exception e) {
    }
}