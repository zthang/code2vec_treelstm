private static void run(int N) {
    try {
        DEBUG = Integer.parseInt(System.getProperties().get("DEBUG").toString());
    } catch (Throwable t) {
    }
    for (int n = 1; n <= N; ++n) {
        Object res = new E().solve();
        if (res != null) {
            @SuppressWarnings("all")
            Object o = CONTEST_TYPE == 0 ? "Case #" + n + ": " + build(res) : res;
            print(o);
        }
    }
    exit();
}