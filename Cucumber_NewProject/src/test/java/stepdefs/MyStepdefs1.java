package stepdefs;

import io.cucumber.java.en.Given;

public class MyStepdefs1 {
    @Given("user write {string}")
    public void userWrite(String text) {

        System.out.println(text);
    }
}
