package adubolazov.quiz.pixelcomponent;

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
}
