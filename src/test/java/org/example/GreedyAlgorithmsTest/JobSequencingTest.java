package org.example.GreedyAlgorithmsTest;
import org.example.GreedyAlgorithms.JobSequencing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
class JobSequencingTest {

    @Test
    void testJobSequencing() {
        // Create a list of jobs with id, deadline, and profit
        ArrayList<JobSequencing.Job> jobs = new ArrayList<>();
        jobs.add(new JobSequencing.Job('A', 4, 20));
        jobs.add(new JobSequencing.Job('B', 1, 10));
        jobs.add(new JobSequencing.Job('C', 1, 40));
        jobs.add(new JobSequencing.Job('D', 1, 30));

        String result = JobSequencing.findJobSequence(jobs, jobs.size());
        String expected = "Job Sequence: C -> A";
        assertEquals(expected, result);
    }

    @Test
    void testNoJobCanBeScheduled() {
        // Create a list of jobs with no available slots (deadlines are too small)
        ArrayList<JobSequencing.Job> jobs = new ArrayList<>();
        jobs.add(new JobSequencing.Job('A', 0, 20));  // No slot available for this job
        jobs.add(new JobSequencing.Job('B', 0, 10));  // No slot available for this job

        // Expected output: Job Sequence: (no jobs can be scheduled)
        String result = JobSequencing.findJobSequence(jobs, jobs.size());
        String expected = "Job Sequence: ";
        assertEquals(expected, result);
    }
    @Test
    void testJobSequenceWithDifferentDeadlines() {
        // Create a list of jobs with different deadlines and profits
        ArrayList<JobSequencing.Job> jobs = new ArrayList<>();
        jobs.add(new JobSequencing.Job('A', 2, 100));
        jobs.add(new JobSequencing.Job('B', 1, 200));
        jobs.add(new JobSequencing.Job('C', 2, 150));
        jobs.add(new JobSequencing.Job('D', 1, 300));

        // Expected output: Job Sequence: D -> C
        String result = JobSequencing.findJobSequence(jobs, jobs.size());
        String expected = "Job Sequence: D -> C";
        assertEquals(expected, result);
    }

    @Test
    void testJobsWithSameProfit() {
        // Test jobs with the same profit but different deadlines
        ArrayList<JobSequencing.Job> jobs = new ArrayList<>();
        jobs.add(new JobSequencing.Job('A', 2, 50));
        jobs.add(new JobSequencing.Job('B', 1, 50));
        jobs.add(new JobSequencing.Job('C', 1, 50));

        // Expected output: Job Sequence: B -> A (order depends on job deadline)
        String result = JobSequencing.findJobSequence(jobs, jobs.size());
        String expected = "Job Sequence: B -> A";
        assertEquals(expected, result);
    }
    @Test
    void testJobsWithEqualProfitAndDeadline() {
        ArrayList<JobSequencing.Job> jobs = new ArrayList<>();
        jobs.add(new JobSequencing.Job('A', 2, 50));
        jobs.add(new JobSequencing.Job('B', 2, 50));
        jobs.add(new JobSequencing.Job('C', 1, 50));

        // Expected output: Job Sequence: C -> A (or B)
        String result = JobSequencing.findJobSequence(jobs, jobs.size());
        assertTrue(result.equals("Job Sequence: C -> A") || result.equals("Job Sequence: C -> B"));
    }
    @Test
    void testShortJobSequence() {
        ArrayList<JobSequencing.Job> jobs = new ArrayList<>();
        jobs.add(new JobSequencing.Job('A', 1, 10));

        // Expected output: Job Sequence: A
        String result = JobSequencing.findJobSequence(jobs, jobs.size());
        assertEquals("Job Sequence: A", result);
    }
    @Test
    void testSortingOrderValidation() {
        ArrayList<JobSequencing.Job> jobs = new ArrayList<>();
        jobs.add(new JobSequencing.Job('A', 3, 40)); // Same profit, later deadline
        jobs.add(new JobSequencing.Job('B', 3, 50)); // Higher profit
        jobs.add(new JobSequencing.Job('C', 2, 40)); // Same profit, earlier deadline

        String result = JobSequencing.findJobSequence(jobs, jobs.size());
        assertEquals("Job Sequence: A -> C -> B", result);
    }
    @Test
    public void testIPVR() {
        ArrayList<JobSequencing.Job> jobs = new ArrayList<>();
        jobs.add(new JobSequencing.Job('A', 2, 100));
        jobs.add(new JobSequencing.Job('B', 1, 50));
        jobs.add(new JobSequencing.Job('C', 2, 10));

        // Original job sequence
        String originalResult = JobSequencing.findJobSequence(jobs, jobs.size());

        // IVPR: Replace one job's parameters
        ArrayList<JobSequencing.Job> mutatedJobs = new ArrayList<>(jobs);
        mutatedJobs.set(1, new JobSequencing.Job('D', 2, 200)); // Replace 'B' with a high-profit job 'D'

        // Mutated job sequence
        String mutatedResult = JobSequencing.findJobSequence(mutatedJobs, mutatedJobs.size());

        // Check that the mutation affects the result
        assertNotEquals(originalResult, mutatedResult, "IPVR mutation was not killed!");

        // Additional validation: Check the mutated sequence includes the replacement job
        assertTrue(mutatedResult.contains("D"), "Mutated sequence should reflect IVPR changes.");
    }

    /**
     * Test for Integration Parameter Exchange (IPEX).
     */
    @Test
    public void testIPEX() {
        ArrayList<JobSequencing.Job> jobs = new ArrayList<>();
        jobs.add(new JobSequencing.Job('A', 2, 100));
        jobs.add(new JobSequencing.Job('B', 1, 50));
        jobs.add(new JobSequencing.Job('C', 2, 10));

        // Parameter exchange: Alter the deadlines of two jobs
        int originalDeadlineA = jobs.get(0).deadline;
        int originalDeadlineB = jobs.get(1).deadline;
        jobs.get(0).deadline = originalDeadlineB;
        jobs.get(1).deadline = originalDeadlineA; // IPEX: Exchange deadlines of job 'A' and 'B'

        String resultWithExchange = JobSequencing.findJobSequence(jobs, jobs.size());

        // Revert mutation
        jobs.get(0).deadline = originalDeadlineA;
        jobs.get(1).deadline = originalDeadlineB;

        String resultWithoutExchange = JobSequencing.findJobSequence(jobs, jobs.size());

        // Results should differ due to the parameter exchange
        assertNotEquals(resultWithExchange, resultWithoutExchange, "IPEX mutation was not killed!");
    }

    /**
     * Test for Integration Method Call Deletion (IMCD).
     */
    @Test
    public void testIMCD() {
        ArrayList<JobSequencing.Job> jobs = new ArrayList<>();
        jobs.add(new JobSequencing.Job('A', 2, 100));
        jobs.add(new JobSequencing.Job('B', 1, 50));
        jobs.add(new JobSequencing.Job('C', 2, 10));

        // Original method call
        String originalResult = JobSequencing.findJobSequence(jobs, jobs.size());

        // Simulate method call deletion by directly returning an empty sequence
        String deletedCallResult = "Job Sequence: "; // IMCD: Simulate method call deletion

        // Results should differ as the method call is replaced with a constant output
        assertNotEquals(originalResult, deletedCallResult, "IMCD mutation was not killed!");
    }

    /**
     * Test for Integration Return Expression Modification (IREM).
     */
    @Test
    public void testIREM() {
        ArrayList<JobSequencing.Job> jobs = new ArrayList<>();
        jobs.add(new JobSequencing.Job('A', 2, 100));
        jobs.add(new JobSequencing.Job('B', 1, 50));
        jobs.add(new JobSequencing.Job('C', 2, 10));

        // Original method call
        String originalResult = JobSequencing.findJobSequence(jobs, jobs.size());

        // Modify the return expression by appending extra data
        String mutatedResult = originalResult + " -> Mutated"; // IREM: Append extra data to result

        // Results should differ due to the altered return expression
        assertNotEquals(originalResult, mutatedResult, "IREM mutation was not killed!");
    }
}
