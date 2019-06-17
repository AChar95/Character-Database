package com.qa.RunCategories;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import com.qa.Categories.CategoryThree;
import com.qa.seleniumTest.CreateTests;
import com.qa.seleniumTest.DeleteTest;
import com.qa.seleniumTest.UpdateAndReadTest;

@RunWith(Categories.class)
@IncludeCategory(CategoryThree.class)
@SuiteClasses({CreateTests.class, UpdateAndReadTest.class, DeleteTest.class})

public class RunCategoryThree {

}
