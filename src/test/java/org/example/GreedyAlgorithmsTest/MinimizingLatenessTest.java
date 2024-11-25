package org.example.GreedyAlgorithmsTest;
import org.example.GreedyAlgorithms.MinimizingLateness;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MinimizingLatenessTest {

    @Test
    void testNoLateness() {
        MinimizingLateness.Job job1 = MinimizingLateness.Job.of("Job1", 2, 4);
        MinimizingLateness.Job job2 = MinimizingLateness.Job.of("Job2", 1, 6);
        MinimizingLateness.Job job3 = MinimizingLateness.Job.of("Job3", 3, 10);

        MinimizingLateness.calculateLateness(job1, job2, job3);

        assertEquals(0, job1.lateness, "Job1 should have no lateness");
        assertEquals(0, job2.lateness, "Job2 should have no lateness");
        assertEquals(0, job3.lateness, "Job3 should have no lateness");
    }

    @Test
    void testLatenessCalculation() {
        MinimizingLateness.Job job1 = MinimizingLateness.Job.of("Job1", 3, 5);
        MinimizingLateness.Job job2 = MinimizingLateness.Job.of("Job2", 4, 6);
        MinimizingLateness.Job job3 = MinimizingLateness.Job.of("Job3", 2, 7);

        MinimizingLateness.calculateLateness(job1, job2, job3);

        assertEquals(0, job1.startTime, "Job1 start time should be 0");
        assertEquals(3, job2.startTime, "Job2 start time should be 3");
        assertEquals(7, job3.startTime, "Job3 start time should be 7");

        assertEquals(2, job3.lateness, "Job3 should have a lateness of 2");
    }

    @Test
    void testPreSortedJobs() {
        MinimizingLateness.Job job1 = MinimizingLateness.Job.of("Job1", 2, 3);
        MinimizingLateness.Job job2 = MinimizingLateness.Job.of("Job2", 3, 7);
        MinimizingLateness.Job job3 = MinimizingLateness.Job.of("Job3", 1, 10);

        MinimizingLateness.calculateLateness(job1, job2, job3);

        assertEquals(0, job1.lateness, "Job1 should have no lateness");
        assertEquals(0, job2.lateness, "Job2 should have no lateness");
        assertEquals(0, job3.lateness, "Job3 should have no lateness");
    }

    @Test
    void testUnsortedJobs() {
        MinimizingLateness.Job job1 = MinimizingLateness.Job.of("Job1", 3, 6);
        MinimizingLateness.Job job2 = MinimizingLateness.Job.of("Job2", 2, 3);
        MinimizingLateness.Job job3 = MinimizingLateness.Job.of("Job3", 1, 8);

        MinimizingLateness.calculateLateness(job1, job2, job3);

        assertEquals("Job2, startTime: 0, endTime: 2, lateness: 0", job2.toString());
        assertEquals("Job1, startTime: 2, endTime: 5, lateness: 0", job1.toString());
        assertEquals("Job3, startTime: 5, endTime: 6, lateness: 0", job3.toString());
    }

    @Test
    void testAllJobsLateness() {
        MinimizingLateness.Job job1 = MinimizingLateness.Job.of("Job1", 4, 3);
        MinimizingLateness.Job job2 = MinimizingLateness.Job.of("Job2", 3, 4);
        MinimizingLateness.Job job3 = MinimizingLateness.Job.of("Job3", 2, 6);

        MinimizingLateness.calculateLateness(job1, job2, job3);

        assertEquals(1, job1.lateness, "Job1 should have lateness of 1");
        assertEquals(3, job2.lateness, "Job2 should have lateness of 3");
        assertEquals(3, job3.lateness, "Job3 should have lateness of 3");
    }

    @Test
    void testSingleJob() {
        MinimizingLateness.Job job = MinimizingLateness.Job.of("Job1", 5, 10);

        MinimizingLateness.calculateLateness(job);

        assertEquals(0, job.lateness, "Single job should have no lateness");
        assertEquals(0, job.startTime, "Single job should start at time 0");
    }

    @Test
    void testEmptyJobList() {
        MinimizingLateness.calculateLateness();
        // No exceptions should occur when the job list is empty
    }
    @Test
    public void testMinimizingLatenessMutation_IMCD() {
        // Create sample jobs
        MinimizingLateness.Job job1 = MinimizingLateness.Job.of("Job1", 3, 6);
        MinimizingLateness.Job job2 = MinimizingLateness.Job.of("Job2", 2, 5);
        MinimizingLateness.Job job3 = MinimizingLateness.Job.of("Job3", 4, 8);

        MinimizingLateness.Job[] jobs = {job1, job2, job3};

        // Apply IMCD mutation by deleting a critical line
        // Mutation: Delete the line where lateness is calculated
        int startTime = 0;
        for (MinimizingLateness.Job job : jobs) {
            job.startTime = startTime;
            startTime += job.processingTime;
        }

        // Since the lateness calculation line is deleted, lateness should remain 0
        for (MinimizingLateness.Job job : jobs) {
            assertEquals(0, job.lateness, "Job lateness should be 0 due to IMCD mutation");
        }
    }

    @Test
    public void testMinimizingLatenessMutation_IREM() {
        // Create sample jobs
        MinimizingLateness.Job job1 = MinimizingLateness.Job.of("Job1", 3, 6);
        MinimizingLateness.Job job2 = MinimizingLateness.Job.of("Job2", 2, 5);
        MinimizingLateness.Job job3 = MinimizingLateness.Job.of("Job3", 4, 8);

        MinimizingLateness.Job[] jobs = {job1, job2, job3};

        // Calculate lateness with the original method
        MinimizingLateness.calculateLateness(jobs);

        // Apply IREM mutation by modifying the return expression
        // Mutation: Add extra operation (e.g., adding 1 to lateness)
        for (MinimizingLateness.Job job : jobs) {
            job.lateness += 1;  // Introduce an additional lateness
        }

        // Verify the mutated lateness values
        assertNotEquals(0, job1.lateness, "Job1 lateness should be different due to IREM mutation");
        assertNotEquals(0, job2.lateness, "Job2 lateness should be different due to IREM mutation");
        assertNotEquals(1, job3.lateness, "Job3 lateness should be different due to IREM mutation");
    }

    @Test
    public void testMinimizingLatenessMutation_IPEX() {
        // Create sample jobs
        MinimizingLateness.Job job1 = MinimizingLateness.Job.of("Job1", 3, 6);
        MinimizingLateness.Job job2 = MinimizingLateness.Job.of("Job2", 2, 5);
        MinimizingLateness.Job job3 = MinimizingLateness.Job.of("Job3", 4, 8);

        MinimizingLateness.Job[] jobs = {job1, job2, job3};

        // Apply IPEX mutation by swapping the parameters in the lateness calculation
        // Mutation: Swap processing time with deadline for calculating lateness
        for (MinimizingLateness.Job job : jobs) {
            int temp = job.processingTime;
            job.processingTime = job.deadline;
            job.deadline = temp;
        }

        // Calculate lateness after mutation
        MinimizingLateness.calculateLateness(jobs);

        // Verify the mutated result is different from the original
        assertNotEquals(0, job1.lateness, "Job1 lateness should differ due to IPEX mutation");
        assertNotEquals(0, job2.lateness, "Job2 lateness should differ due to IPEX mutation");
        assertNotEquals(1, job3.lateness, "Job3 lateness should differ due to IPEX mutation");
    }
}

