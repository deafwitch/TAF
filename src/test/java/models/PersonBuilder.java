package models;

import lombok.*;

@Builder
@ToString(exclude = "UUID")
@EqualsAndHashCode(exclude = "UUID")
public class PersonBuilder {
    /**
     * Age of the person
     *
     * @param age New value for this person's age.
     * @return The current value of this person's age.
     */
    private int age = 10;

    /**
     * Name of the person
     *
     * @param name New value for this person's name.
     * @return The current value of this person's name.
     */
    private String name;

    @NonNull
    private String surname;

    private int UUID;
}
