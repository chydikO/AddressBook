package com.chudik0.addressbook.interfaces.impls;

import com.chudik0.addressbook.interfaces.AddressBook;
import com.chudik0.addressbook.objects.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Random;

public class CollectionAddressBook implements AddressBook {
    private final ObservableList<Person> personArrayList = FXCollections.observableArrayList();

    @Override
    public void addPerson(Person person) {
        personArrayList.add(person);
    }

    @Override
    public void editPerson(Person person) {

    }

    @Override
    public void deletePerson(Person person) {
        personArrayList.remove(person);
    }

    public ObservableList<Person> getPersonArrayList() {
        return personArrayList;
    }

    public void fillTestData() {
        Random random = new Random();
        String[] names = {"John", "Alice", "Bob", "Emma", "Michael", "Olivia", "David", "Sophia", "James", "Emily"};
        String[] lastNames = {"Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor"};

        for (int i = 0; i < 20; i++) {
            String firstName = names[random.nextInt(names.length)];
            String lastName = lastNames[random.nextInt(lastNames.length)];
            String phone = String.valueOf(random.nextInt(900000000) + 100000000);

            Person person = new Person(firstName + " " + lastName, phone);
            personArrayList.add(person);
        }
    }
}
