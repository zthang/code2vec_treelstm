private void specifyValue() {
    for (Node child : children) {
        child.specifyValue();
        if (child.value > 0) {
            value += child.value;
        }
    }
    if (color) {
        value++;
    } else {
        value--;
    }
}