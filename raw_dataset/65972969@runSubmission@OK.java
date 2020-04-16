public void runSubmission(InputStream in, OutputStream out, OutputStream debug) {
    this.in = in;
    this.sc = new FastScanner(this.in);
    this.out = new PrintStream(out);
    this.debug = debug instanceof VoidOutputStream || debug instanceof VoidPrintStream ? new VoidPrintStream() : new DebugPrintStream(debug);
    ContestType type = getType();
    testCaseCount = type.testCaseCount;
    init();
    if (testCaseCount <= 0) {
        testCaseCount = sc.nextInt();
        sc.nextLine();
    }
    testCaseIndex = 0;
    for (testCaseIndex = 1; testCaseIndex <= testCaseCount; testCaseIndex++) {
        progress = 0;
        this.out.printf(type.caseString, testCaseIndex, testCaseCount);
        testCase();
    }
}