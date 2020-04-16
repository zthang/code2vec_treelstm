/**
 * sets st to null!
 */
public String[] nextTower(int lines) throws IOException {
    String[] tower = new String[lines];
    st = null;
    for (int i = 0; i < lines; i++) {
        tower[i] = br.readLine();
    }
    return tower;
}