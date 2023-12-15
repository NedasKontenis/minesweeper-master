class EmptyCell implements Cell {
    private char displayValue;
    private boolean flagged = false;

    public EmptyCell(char displayValue) {
        this.displayValue = displayValue;
    }

    @Override
    public char getDisplayValue() {
        if (flagged) {
            return 'F';
        }
        return displayValue;
    }

    @Override
    public void setDisplayValue(char displayValue) {
        this.displayValue = displayValue;
    }

    @Override
    public boolean isFlagged() {
        return flagged;
    }

    @Override
    public void setFlagged(boolean flagged) {
        this.flagged = flagged;
    }
}