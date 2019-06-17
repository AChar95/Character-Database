package com.qa.seleniumTest;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.qa.runCategories.RunCategoryOne;
import com.qa.runCategories.RunCategoryThree;
import com.qa.runCategories.RunCategoryTwo;

public class Runner {
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(RunCategoryOne.class, RunCategoryTwo.class, RunCategoryThree.class);
		if (result.wasSuccessful()) {
			System.out.println("Success");
		} else {
			System.out.println("Test failures!:");
			for (Failure failure : result.getFailures()) {
				System.out.println(failure.getMessage());
			}
		}
	}
}
