package com.chudik0.addressbook.interfaces;

import com.chudik0.addressbook.objects.Person;

public interface AddressBook {
    void addPerson(Person person);
    void editPerson(Person person);
    void deletePerson(Person person);
}
