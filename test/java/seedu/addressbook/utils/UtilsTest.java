package seedu.addressbook.utils;

import static org.junit.Assert.*;
import static seedu.addressbook.common.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import seedu.addressbook.commands.HelpCommand;
import seedu.addressbook.common.Utils;


public class UtilsTest {
	
    
    @Test
    public void isAnyNull_nullInputs_returnsTrue() {
        assertTrue(Utils.isAnyNull(new Integer(5), "Hi", null, new Utils()));
    }

    @Test
    public void isAnyNull_noNullInputs_returnsFalse() {
        assertFalse(Utils.isAnyNull(new Integer(5), "Hi", new Utils()));
    }

    @Test
    public void isAnyNull_noInputs_returnsFalse() {
        assertFalse(Utils.isAnyNull());
    }
    
    @Test
    public void elementsAreUnique_noInputs_returnsTrue() {
    	ArrayList<Integer> ints = new ArrayList<Integer>();
        assertTrue(Utils.elementsAreUnique(ints));
    }

    @Test
    public void elementsAreUnique_uniqueInputs_returnsTrue() {
    	ArrayList<Integer> ints = new ArrayList<Integer>();
    	ints.add(1);
    	ints.add(2);
    	ints.add(3);
        assertTrue(Utils.elementsAreUnique(ints));
    }

    @Test
    public void elementsAreUnique_nonUniqueInputs_returnsFalse() {
    	ArrayList<Integer> ints = new ArrayList<Integer>();
    	ints.add(1);
    	ints.add(1);
    	ints.add(3);
        assertFalse(Utils.elementsAreUnique(ints));
    }
}
