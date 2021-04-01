package com.nextivr.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This will contain a list of steps to perform in the vxml test, the test name,
 * and the language being tested.
 */
public class Test {
    private List<Step> steps = new ArrayList<Step>();
    private String language = "en-US";
    private String testName = "genericTest";

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    public void addStep(Step step) {
        steps.add(step);
    }

    public List<Step> getSteps() {
        return steps;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

}
