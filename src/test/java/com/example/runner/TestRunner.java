package com.example.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import java.io.File;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.example.aiointegration.ResultUploaderToAIOTest;
import com.example.utils.ConfigReader;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = {  
        "com.example.stepdefinations", "com.example.hooks"}, plugin = {
                "pretty",
                "html:target/cucumber-reports.html",
                "json:target/cucumber-reports.json"  
        }, publish = true
        )
public class TestRunner {
    
}
