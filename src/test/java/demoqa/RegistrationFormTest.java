package demoqa;
import org.junit.jupiter.api.Test;

public class RegistrationFormTest extends TestBase{

    @Test
    void fillFormTest() {
        registrationPage.openPage()
                        .typeFirstName(TestData.firstName)
                        .typeLastName(TestData.lastName)
                        .typeEmail(TestData.email)
                        .chooseGender("Female")
                        .typePhoneNumber(TestData.phoneNumber)
                        .setBirthdayDate("2001", "February")
                        .chooseSubject("Maths")
                        .setHobbies("Reading")
                        .uploadPicture("test.jpg")
                        .typeAddress(TestData.address)
                        .setState("NCR")
                        .setCity("Delhi")
                        .submitForm();
        registrationPage.checkResultsValue("Student Name", TestData.firstName + " " + TestData.lastName)
                .checkResultsValue("Student Email", TestData.email)
                .checkResultsValue("Gender", "Female")
                .checkResultsValue("Mobile", TestData.phoneNumber)
                .checkResultsValue("Date of Birth", "03 February,2001")
                .checkResultsValue("Subjects", "Maths")
                .checkResultsValue("Hobbies", "Reading")
                .checkResultsValue("Picture", "test.jpg")
                .checkResultsValue("Address", TestData.address)
                .checkResultsValue("State and City", "NCR Delhi");
    }
}
