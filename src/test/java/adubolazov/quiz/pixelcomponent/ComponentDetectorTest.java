package adubolazov.quiz.pixelcomponent;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ComponentDetectorTest {
    
    private static final int[][] M_2_COMPONENTS_CASE_1 = {{0, 1, 0, 0, 0}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}};

    private static final int[][] M_2_COMPONENTS_CASE_2 = {{0, 1, 0, 0, 0}, {1, 1, 1, 0, 0}, {0, 0, 0, 1, 1}};

    private static final int[][] M_4_COMPONENTS = {{0, 1, 0}, {1, 0, 1}, {0, 1, 0}};

    @Test
    public void testGetComponentsCount() {
        assertEquals(2, ComponentDetector.getComponentsCount(M_2_COMPONENTS_CASE_1));
        assertEquals(2, ComponentDetector.getComponentsCount(M_2_COMPONENTS_CASE_2));
        assertEquals(4, ComponentDetector.getComponentsCount(M_4_COMPONENTS));
        assertEquals(0, ComponentDetector.getComponentsCount(null));
    }
}
