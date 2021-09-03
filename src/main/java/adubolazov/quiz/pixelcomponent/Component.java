package adubolazov.quiz.pixelcomponent;

import java.util.HashSet;
import java.util.Set;

public class Component {
    private Set<Pixel> pixels;

    public Component(Pixel startPixel) {
        super();
        pixels = new HashSet<>();
        pixels.add(startPixel);
    }

    public Set<Pixel> getPixels() {
        return pixels;
    }
    
    public void addPixel(Pixel pixel) {
        pixels.add(pixel);
    }

    public void merge(Component other) {
        pixels.addAll(other.getPixels());
    }
}
