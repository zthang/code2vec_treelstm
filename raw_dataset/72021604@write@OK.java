private void write() throws IOException {
    int refereesSize, roosterSize;
    Set<Integer> referees = answer(exitEdges);
    if (referees.size() != n) {
        refereesSize = referees.size();
        roosterSize = n - refereesSize;
        writer.write("Yes\n");
        writer.write(refereesSize + " " + roosterSize + "\n");
        for (Integer i : referees) {
            refereesSize--;
            if (refereesSize == 0)
                writer.write(i + "\n");
            else
                writer.write(i + " ");
        }
        for (int i = 1; i <= n; i++) {
            if (!referees.contains(i)) {
                roosterSize--;
                if (roosterSize == 0)
                    writer.write(i + "\n");
                else
                    writer.write(i + " ");
            }
        }
    } else {
        Set<Integer> roosters = answer(enterEdges);
        if (roosters.size() == n) {
            writer.write("No\n");
            return;
        }
        writer.write("Yes\n");
        roosterSize = roosters.size();
        refereesSize = n - roosterSize;
        writer.write(refereesSize + " " + roosters.size() + "\n");
        for (int i = 1; i <= n; i++) if (!roosters.contains(i)) {
            refereesSize--;
            if (refereesSize == 0)
                writer.write(i + "\n");
            else
                writer.write(i + " ");
        }
        for (Integer i : roosters) {
            roosterSize--;
            if (roosterSize == 0)
                writer.write(i + "\n");
            else
                writer.write(i + " ");
        }
    }
}