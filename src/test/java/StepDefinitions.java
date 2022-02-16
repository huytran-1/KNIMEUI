import io.cucumber.java.en.Given;
import org.junit.jupiter.api.Assertions;

public class StepDefinitions extends Steps {

    @Given("I launch knime webpage")
    public void i_launch_knime_webpage() throws InterruptedException {
        lauchWebpage("https://hub.knime.com");
        clickElement("AcceptCookie");
    }

    @Given("I click on sign in button")
    public void i_click_on_signin_button(){
        clickElement("Login");
    }

    @Given("I enter username {string} and password {string}")
    public void i_enter_username_and_password(String userName, String password) {
        enterText("Username", userName);
        enterText("Password", password);
        clickElement("Submit");
    }


    @Given("I go to Spaces")
    public void i_go_to_spaces() {
        clickElement("Login");
        clickElement("MySpace");
    }
    @Given("I create new public space")
    public void i_create_new_public_space() {
        clickElement("CreateNewSpace");
        wait(3);
        clickElement("SpaceNameTextBox");
        clearText("SpaceNameTextBox");
        enterText("SpaceNameTextBox", "SpaceName");
        clickElement("SaveButton");
    }
    @Given("I delete the created space")
    public void i_delete_the_created_space() throws InterruptedException {
        wait(5);
        clickElement("EditButton");
        wait(5);
        clickElement("Delete");
        clickElement("DeleteSpaceName");
        wait(2);
        enterText("DeleteSpaceName", "SpaceName");
        wait(5);
        clickElement("DeleteSubmit");
    }
    @Given("I verify space is deleted")
    public void i_verify_space_is_deleted() {
        String header = getText("MySpaceHeader");
        Assertions.assertTrue(header.contains("Your spaces"));
    }
}
