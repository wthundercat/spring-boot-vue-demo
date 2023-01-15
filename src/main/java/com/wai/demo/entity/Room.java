package com.wai.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.wai.demo.enums.RoomAvailability;

import javax.persistence.*;

@Entity
@Table(name="room")
public class Room {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "room_seq"
    )
    @SequenceGenerator(
            name = "room_seq",
            allocationSize = 1
    )
    String room_id;

    @Column(name = "room_number")
    String roomNumber;

    @Column(name = "is_available")
    @Enumerated(EnumType.STRING)
    RoomAvailability isAvailable;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    @JsonBackReference
    private Customer customer;


    public String getRoom_id() {
        return room_id;
    }

    public void setRoom_id(String room_id) {
        this.room_id = room_id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public RoomAvailability getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(RoomAvailability isAvailable) {
        this.isAvailable = isAvailable;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
