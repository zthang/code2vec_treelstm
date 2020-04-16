public void markImpossible(int i) {
    i = find(i);
    // System.out.println("Marking "+i+" as impossible");
    minSize -= costChoice(i);
    impossible[i] = true;
    minSize += costChoice(i);
}