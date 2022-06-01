package models;

import lombok.Getter;
import lombok.Setter;

public class Person {
    /**
     * Age of the person
     *
     * @param age New value for this person's age.
     * @return The current value of this person's age.
     */
    @Getter @Setter private int age = 10;
}
