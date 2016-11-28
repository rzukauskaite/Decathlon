package com.decathlon.app.domain;

import com.google.common.base.Joiner;
/**
 * DTO to carry party name information.
 *
 * @author redaz
 */
public class PartyNameDTO {
    /**
     * Person first name.
     */
    private String firstName;
    /**
     * Person middle name
     */
    private String middleName;
    /**
     * Person last name.
     */
    private String lastName;
    /**
     * Person name display value.
     * <p>
     * <b>Note:</b> display value is combined of first and last names, i.e.:
     * Marry Smith.
     */
    private String displayName;

    public PartyNameDTO() { }

    public PartyNameDTO(String firstName, String lastName) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.displayName = resolveDisplayValue(firstName, lastName);
    }

    public PartyNameDTO(String firstName, String middleName, String lastName) {
        this(firstName, lastName);
        this.middleName = middleName;
        this.displayName = resolveDisplayValue(firstName, middleName, lastName);
    }

    public PartyNameDTO(String displayName) {
        this.displayName = displayName;
        this.firstName = resolveFirstName(displayName);
        this.lastName = resolveLastName(displayName);
    }

    /**
     * Resolves last name from party name display value.
     * @param displayName party display name of following format: "<firstName> <middleName> <lastName>"
     * @return party last name
     */
    protected String resolveLastName(String displayName) {
        String[] names = displayName.split(" ");
        return names[names.length-1];
    }

    /**
     * Resolves first name from party name display value.
     * @param displayName party display name of following format: "<firstName> <middleName> <lastName>"
     * @return party first name
     */
    protected String resolveFirstName(String displayName) {
        String[] names = displayName.split(" ");
        return names[0];
    }

    /**
     * Resolves party name display value.
     * @param names list of party names, i.e.: firstName, middleName, lastName. MiddleName can be null
     * @return party name display value
     */
    protected String resolveDisplayValue(String... names) {
        return Joiner.on(" ").skipNulls().join(names);
    }

    @Override
    public String toString() {
        return displayName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
