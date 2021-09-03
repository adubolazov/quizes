package adubolazov.quiz.pixelcomponent;

import java.util.ArrayList;
import java.util.List;

public class ComponentDetector {
    
    private ComponentDetector() {
        super();
    }

    public static int getComponentsCount(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        } else if (matrix.length > 100000 || matrix[0].length > 100000) {
            throw new RuntimeException("Matrix exeeds the size limit") ;
        } else {
            List<Component> components = new ArrayList<>();
            for(int i = 0; i < matrix.length; i++) {
                for(int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] == 1) {
                        checkPixel(new Pixel(i, j), components);
                    }
                }
            }
            return components.size();
        }
    }

    private static void checkPixel(Pixel pixel, List<Component> components) {
        List<Component> mergedComponents = new ArrayList<>();
        components.forEach(c -> {
            if (c.getPixels().stream().anyMatch(p -> p.isNeighbor(pixel))) {
                c.addPixel(pixel);
                mergedComponents.add(c);
            }
        });
        if (mergedComponents.isEmpty()) {
            components.add(new Component(pixel));
        } else if (mergedComponents.size() > 1) {
            Component prime = mergedComponents.get(0);
            mergedComponents.stream().skip(1).forEach(c -> {
                prime.merge(c);
                components.remove(c);
            });
        }
    }
}
