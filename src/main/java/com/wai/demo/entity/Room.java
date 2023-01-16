package com.wai.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.wai.demo.enums.RoomAvailability;

import javax.persistence.*;

@Entity
@Table(name="room")
public class Room {

    @Id
    @Column(name = "room_id")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "room_seq"
    )
    @SequenceGenerator(
            name = "room_seq",
            allocationSize = 1
    )
    long roomId;

    @Column(name = "room_number")
    String roomNumber;

    @Column(name = "is_available")
    @Enumerated(EnumType.STRING)
    RoomAvailability isAvailable;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    @JsonBackReference
    private Customer customer;


    public long getRoom_id() {
        return roomId;
    }

    public void setRoom_id(long roomId) {
        this.roomId = roomId;
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
