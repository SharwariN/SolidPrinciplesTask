package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.infy.exception.InfyAcademyException;

import application.EmailValidator;

public class EmailValidatorTest {
	
	EmailValidator emailValidator;
	
	@BeforeEach
	void setUp() throws Exception {
		emailValidator = new EmailValidator();
	}

	@AfterEach
	void tearDown() throws Exception {
		emailValidator = null;
	}
	
	@Test
	public void validateEmailIdValidEmailId() throws InfyAcademyException {
		assertTrue(emailValidator.validateEmailId("shashank@infy.com"));
	}

	@Test
	public void validateEmailIdInvalidEmailId() throws InfyAcademyException {
		assertFalse(emailValidator.validateEmailId("shashank@infy.org"));
	}

	@Test
	public void validateEmailIdInvalidEmailIdException() throws InfyAcademyException {
		assertThrows(InfyAcademyException.class, () -> emailValidator.validateEmailId(null));
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"HarveySpectar", "Mike_Ross@PS.in", "Donna", "RachelZane@law.com"})
	public void validateEmailIdParamterizedEmailId(String email) throws InfyAcademyException {
		assertTrue(emailValidator.validateEmailId(email));
	}
}
