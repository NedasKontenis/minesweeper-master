class MineCell implements Cell {
    private char displayValue;
    private boolean flagged = false;

    public MineCell() {
        this.displayValue = '-';
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