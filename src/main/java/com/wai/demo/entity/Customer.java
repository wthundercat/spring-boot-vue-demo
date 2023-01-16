package com.wai.demo.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="customer")

@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "findCustomers",
                procedureName = "FIND_CUSTOMERS_BY_ADDRESS",
                resultClasses = Customer.class,
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "some_cursor", type = Void.class)

                })



})
public class Customer {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_seq"
    )
    @SequenceGenerator(
            name = "customer_seq",
            allocationSize = 1
    )
    long customer_id;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;

    @Column(name = "age")
    String age;

    @Column(name = "address")
    String address;

    @OneToMany(
            mappedBy = "customer",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Room> rooms = new ArrayList<>();

    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void addRoom(Room room) {
        rooms.add(room);
        room.setCustomer(this);
    }

    public void removeComment(Room room) {
        rooms.remove(room);
        room.setCustomer(null);
    }
}
