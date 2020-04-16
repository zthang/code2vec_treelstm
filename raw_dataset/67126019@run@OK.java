/* -------------------- Templates and Input Classes -------------------------------*/
@Override
public void run() {
    try {
        init();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    solve();
    out.flush();
}