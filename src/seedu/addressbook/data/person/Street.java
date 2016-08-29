package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;
public class Street {

    public static final String MESSAGE_STREET_CONSTRAINTS =
            "Street cannot contain a comma.";
    public static final String STREET_VALIDATION_REGEX = "[^,]*";

    public final String value;
    private boolean isPrivate;

    /**
     * Validates given street.
     *
     * @throws IllegalValueException if given street string is invalid.
     */
    public Street(String street, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        street = street.trim();
        if (!isValidStreet(street)) {
            throw new IllegalValueException(MESSAGE_STREET_CONSTRAINTS);
        }
        this.value = street;
    }

    /**
     * Checks if a given string is a valid street.
     */
    public static boolean isValidStreet(String test) {
        return test.matches(STREET_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Street // instanceof handles nulls
                && this.value.equals(((Street) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }


    public boolean isPrivate() {
        return isPrivate;
    }
}
