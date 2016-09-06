package seedu.addressbook.data.person;

import static org.junit.Assert.*;

import org.junit.Test;

import seedu.addressbook.commands.HelpCommand;
import seedu.addressbook.data.exception.IllegalValueException;

public class NameTest {

	@Test
    public void name_sameName_returnsTrue() throws IllegalValueException {
		
        Name name1 = new Name("Test");
        Name name2 = new Name("Test");
        assertTrue(name1.isSimilar(name2));
    }
}
