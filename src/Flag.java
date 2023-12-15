import java.util.Objects;

public class Flag {
    private int row;
    private int column;

    public Flag(int row, int column) {
        this.row = row;
        this.column = column;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Flag flag = (Flag) obj;
        return row == flag.row && column == flag.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}
