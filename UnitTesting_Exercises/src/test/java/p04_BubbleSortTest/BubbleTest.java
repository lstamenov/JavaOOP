package p04_BubbleSortTest;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class BubbleTest {
    @Test
    public void testIfBubbleSortsArrayCorrect(){
        int[] elementsForBuildInSortMethod = new int[]{5, 2, 1, 4, 3};
        int[] elementsForBubbleSort = new int[]{5, 2, 1, 4, 3};
        Arrays.sort(elementsForBuildInSortMethod);
        Bubble.sort(elementsForBubbleSort);
        Assert.assertArrayEquals(elementsForBuildInSortMethod, elementsForBubbleSort);
    }
}