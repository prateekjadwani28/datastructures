package com.dsa.miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MS09_JobSequencing {

	public static void main(String[] args) {

		List<Job> jobList = new ArrayList<>();

		jobList.add(new Job(1, 2, 100));
		jobList.add(new Job(2, 1, 19));
		jobList.add(new Job(3, 2, 27));
		jobList.add(new Job(4, 1, 25));
		jobList.add(new Job(5, 3, 35));

		findJobSequencing(jobList);
	}

	/*
	 * Sort the job list in descending order of profit
	 * 
	 * 1 2 100 || 3 2 27 || 4 1 25 || 2 1 19 || 5 3 15
	 * 
	 * */
	private static void findJobSequencing(List<Job> jobList) {
		int n = jobList.size();
		boolean[] status = new boolean[n];
		int day = 0, profit = 0;

		
		Collections.sort(jobList, new Comparator<Job>() {

			@Override
			public int compare(Job o1, Job o2) {
				Integer i1 = o1.profit;
				Integer i2 = o2.profit;
				return i2.compareTo(i1);
			}
		});
		for(int i=0;i<n;i++) {
			// taking minimum because could possible someone gave deadline beyond limit
			for(int j=Math.min(n, jobList.get(i).deadline-1);j>=0;j--){

				if(!status[j]) {
					day = day + 1;
					profit = profit + jobList.get(i).profit;
					status[j] = true;

					break;
				}
			}
		}
		
		System.out.println("Profit : " +profit);
		System.out.println("Day : " +day);
	}
}

class Job {

	int jobId;
	int deadline;
	int profit;


	public Job(int jobId, int deadline, int profit) {
		super();
		this.jobId = jobId;
		this.deadline = deadline;
		this.profit = profit;
	}


	@Override
	public String toString() {
		return "Job [jobId=" + jobId + ", deadline=" + deadline + ", profit=" + profit + "]";
	}
}
