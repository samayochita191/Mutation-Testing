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


}
