@Override
public int compare(fridge o1, fridge o2) {
    if (o2.weight > o1.weight) {
        return -1;
    }
    return 0;
}