package seedu.addressbook.data.person;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, Clementi Ave 3, #12-34, 231534";
    public static final String ADDRESS_SEPERATOR = ", ";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses must be in the format a/BLOCK" + ADDRESS_SEPERATOR + "STREET" + ADDRESS_SEPERATOR + "UNIT" + ADDRESS_SEPERATOR + "POSTAL_CODE";
    public static final String ADDRESS_VALIDATION_REGEX = 
    		"([^,]+)(?:" + ADDRESS_SEPERATOR + "([^,]+))?(?:" + ADDRESS_SEPERATOR + "([^,]+))?(?:" + ADDRESS_SEPERATOR + "([^,]+))?";

    public final Block block;
    public final Street street;
    public final Unit unit;
    public final PostalCode postalCode;
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        if (!isValidAddress(address)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        Matcher matcher = Pattern.compile(ADDRESS_VALIDATION_REGEX).matcher(address);
        matcher.find();

        block = new Block(getMatchOrEmptyString(matcher, 1), true);
        street = new Street(getMatchOrEmptyString(matcher, 2), true);
        unit = new Unit(getMatchOrEmptyString(matcher, 3), true);
        postalCode = new PostalCode(getMatchOrEmptyString(matcher, 4), true);
    }

    private String getMatchOrEmptyString(Matcher m, int index){
    	if(m.group(index) == null){
    		return "";
    	}else{
    		return m.group(index);
    	}
    }
    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return (block.toString().equals("") ? "" : block.toString()) + 
        		(street.toString().equals("") ? "" : ADDRESS_SEPERATOR + street.toString()) + 
        		(unit.toString().equals("") ? "" : ADDRESS_SEPERATOR + unit.toString()) + 
        		(postalCode.toString().equals("") ? "" : ADDRESS_SEPERATOR + postalCode.toString());
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.block.equals(((Address) other).block)
                && this.street.equals(((Address) other).street)
                && this.unit.equals(((Address) other).unit)
                && this.postalCode.equals(((Address) other).postalCode)); // state check
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}