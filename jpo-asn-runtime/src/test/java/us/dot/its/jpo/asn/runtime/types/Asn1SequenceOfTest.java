package us.dot.its.jpo.asn.runtime.types;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Asn1SequenceOfTest {

    // Concrete test implementation of the abstract class
    private static class TestSequence extends Asn1SequenceOf<TestAsn1Type> {
        public TestSequence(long lowerBound, long upperBound) {
            super(TestAsn1Type.class, lowerBound, upperBound);
        }
    }

    // Simple implementation of Asn1Type for testing
    private static class TestAsn1Type implements Asn1Type {
        private final int id;

        public TestAsn1Type(int id) {
            this.id = id;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof TestAsn1Type) {
                return ((TestAsn1Type) obj).id == this.id;
            }
            return false;
        }
    }

    private TestAsn1Type item1, item2, item3;

    @BeforeEach
    void setUp() {
        item1 = new TestAsn1Type(1);
        item2 = new TestAsn1Type(2);
        item3 = new TestAsn1Type(3);
    }

    @Test
    void testAddWithinBounds() {
        // Sequence with min=0, max=3
        TestSequence sequence = new TestSequence(0, 3);

        // Adding within bounds should work
        assertTrue(sequence.add(item1));
        assertTrue(sequence.add(item2));
        assertTrue(sequence.add(item3));

        // Validate size is correct
        assertEquals(3, sequence.size());
        assertDoesNotThrow(sequence::validate);
    }

    @Test
    void testAddExceedingUpperBound() {
        // Sequence with min=0, max=2
        TestSequence sequence = new TestSequence(0, 2);

        // Add items up to limit
        assertTrue(sequence.add(item1));
        assertTrue(sequence.add(item2));

        // Third item should throw exception
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            sequence.add(item3);
        });

        assertTrue(exception.getMessage().contains("exceed maximum allowed size"));
    }

    @Test
    void testIsSizeValidWithEmptySequence() {
        // Sequence with min=0, max=3
        TestSequence validEmptySequence = new TestSequence(0, 3);
        assertDoesNotThrow(validEmptySequence::validate);

        // Sequence with min=1, max=3
        TestSequence invalidEmptySequence = new TestSequence(1, 3);
        assertThrows(IllegalStateException.class, invalidEmptySequence::validate);
    }

    @Test
    void testIsSizeValidWithUnboundedUpperLimit() {
        // Sequence with min=1, max=unbounded (-1)
        TestSequence sequence = new TestSequence(1, -1);

        // Empty sequence should be invalid
        assertThrows(IllegalStateException.class, sequence::validate);

        // Add one item - should be valid
        sequence.add(item1);

        // Add many items - should still be valid with unbounded upper limit
        for (int i = 0; i < 100; i++) {
            sequence.add(new TestAsn1Type(i + 10));
        }
        assertDoesNotThrow(sequence::validate);
    }

    @Test
    void testValidate() {
        // Sequence with min=2, max=4
        TestSequence sequence = new TestSequence(2, 4);

        // Empty sequence should throw exception when validated
        IllegalStateException tooSmallException = assertThrows(IllegalStateException.class, sequence::validate);
        assertTrue(tooSmallException.getMessage().contains("below the minimum required size"));

        // Should not throw exception when meeting minimum
        sequence.add(item1);
        sequence.add(item2);
        assertDoesNotThrow(sequence::validate);
    }

    @Test
    void testValidateAddition() {
        // Sequence with max=2
        TestSequence sequence = new TestSequence(0, 2);

        // Add up to limit
        sequence.add(item1);
        sequence.add(item2);

        // Should throw exception when trying to add beyond limit
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            sequence.add(item3);
        });
        assertTrue(exception.getMessage().contains("would exceed maximum allowed size"));
    }

    @Test
    void testValidateAdditionWithUnboundedUpperLimit() {
        // Sequence with unbounded upper limit
        TestSequence sequence = new TestSequence(0, -1);

        // Add many items
        for (int i = 0; i < 10; i++) {
            sequence.add(new TestAsn1Type(i));
        }
    }
}
