package seedu.addressbook.data;

import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.tag.Tag;

public class Tagging {
	Person person;
	Tag tag;
	boolean isAdd;
	
	public Tagging(Person person, Tag tag, boolean isAdd){
		this.person = person;
		this.tag = tag;
		this.isAdd = isAdd;
	}
	
	@Override
	public String toString(){
		return (isAdd ? "+" : "-") + " " + person.getName() + " [" + tag.tagName + "]";
	}
}
