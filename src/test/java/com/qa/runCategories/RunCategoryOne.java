package com.qa.runCategories;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import com.qa.categories.CategoryOne;
import com.qa.seleniumTest.CreateTests;
import com.qa.seleniumTest.DeleteTest;
import com.qa.seleniumTest.UpdateAndReadTest;

@RunWith(Categories.class)
@IncludeCategory(CategoryOne.class)
@SuiteClasses({CreateTests.class, UpdateAndReadTest.class, DeleteTest.class})

public class RunCategoryOne {

}
