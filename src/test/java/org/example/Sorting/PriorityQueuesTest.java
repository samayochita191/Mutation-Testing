package org.example.Sorting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PriorityQueuesTest {

//    @Test
//    public void testHeapMaxInsert() {
//        int[] heap = new int[5];  // Start with an array of size 5
//
//        // Insert elements to trigger resizing
//        heap = PriorityQueues.heapMax(heap, 7);
//        heap = PriorityQueues.heapMax(heap, 10);
//        heap = PriorityQueues.heapMax(heap, 15);
//        heap = PriorityQueues.heapMax(heap, 20);
//        heap = PriorityQueues.heapMax(heap, 25); // This should trigger resizing
//
//        // After inserting 5 elements, the heap should resize
//        assertEquals(10, heap.length);  // Check that the size of the array is now 10
//        assertEquals(25, heap[0]);    // The root element should be the largest, which is 25
//    }

    @Test
    public void testHeapMaxInsertMultipleElements() {
        int[] heap = new int[10];  // Start with an array of size 10

        // Insert multiple elements into the heap
        heap = PriorityQueues.heapMax(heap, 7);
        heap = PriorityQueues.heapMax(heap, 10);
        heap = PriorityQueues.heapMax(heap, 15);
        heap = PriorityQueues.heapMax(heap, 20);
        heap = PriorityQueues.heapMax(heap, 25);  // Largest element at the root

        // The root should be 25 after all insertions
        assertEquals(25, heap[0]);
        // The heap property should still be maintained (may vary depending on implementation specifics)
    }

    @Test
    public void testHeapMaxInsertResize() {
        int[] heap = new int[5];  // Start with a heap of size 5

        // Insert elements to fill and resize the heap
        heap = PriorityQueues.heapMax(heap, 7);  // Insert an element
        heap = PriorityQueues.heapMax(heap, 10);  // Insert another element
        heap = PriorityQueues.heapMax(heap, 15);  // Insert another element
        heap = PriorityQueues.heapMax(heap, 20);  // Insert another element
        heap = PriorityQueues.heapMax(heap, 25);  // Insert another element
        heap = PriorityQueues.heapMax(heap, 30);  // Insert another element, causing resize

        // After inserting 6 elements, the array should have resized to double its size, i.e., 10
        assertEquals(10, heap.length); // Verify the array size is 10
        assertEquals(30, heap[0]);  // The root should be the largest value
    }

    @Test
    public void testHeapMaxInsertEdgeCase() {
        int[] heap = new int[5];  // Allocate an array with a larger size to accommodate insertions
        heap = PriorityQueues.heapMax(heap, 7);  // Insert an element

        // After inserting one element, the heap should still have a size of 5, with the first element being 7
        int[] expected = {7, 0, 0, 0, 0};
        assertArrayEquals(expected, heap);
    }

    @Test
    public void testHeapMaxInsertSingleElement() {
        int[] heap = new int[1];  // Start with a very small heap size
        heap = PriorityQueues.heapMax(heap, 50);  // Insert a single element

        // After inserting one element, the heap should have a size of 1, with the first element being 50
        assertEquals(50, heap[0]);
    }

    @Test
    public void testHeapMaxInsertMultipleDuplicates() {
        int[] heap = new int[5];  // Start with an array of size 5

        // Insert multiple duplicates into the heap
        heap = PriorityQueues.heapMax(heap, 10);
        heap = PriorityQueues.heapMax(heap, 10);
        heap = PriorityQueues.heapMax(heap, 5);
        heap = PriorityQueues.heapMax(heap, 5);

        // After inserting the duplicates, the largest element (10) should be at the root
        assertEquals(10, heap[0]);
        // The heap property should still be maintained (order inside heap may vary)
    }

    @Test
    public void testHeapMaxInsertNegativeValues() {
        int[] heap = new int[5];  // Start with an array of size 5

        // Insert negative values into the heap
        heap = PriorityQueues.heapMax(heap, -5);
        heap = PriorityQueues.heapMax(heap, -2);
        heap = PriorityQueues.heapMax(heap, -8);

        // After inserting negative values, the largest (least negative) should be at the root
        assertEquals(-2, heap[0]);
    }

    @Test
    public void testHeapMaxInsertZero() {
        int[] heap = new int[5];  // Start with an array of size 5

        // Insert zero into the heap
        heap = PriorityQueues.heapMax(heap, 0);

        // After inserting zero, the largest element should be zero
        assertEquals(0, heap[0]);
    }
}
