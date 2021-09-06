package adubolazov.quiz.pixelcomponent;

import java.util.Objects;

public class Pixel {
    
    private int x;
    private int y;

    public Pixel(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

    public boolean isNeighbor(Pixel other) {
        return Math.abs((x + y) - (other.x + other.y)) == 1;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Pixel && x == ((Pixel)o).x && y == ((Pixel)o).y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
