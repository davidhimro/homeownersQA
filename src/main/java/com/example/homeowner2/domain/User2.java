package com.example.homeowner2.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor

public class User2 {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(nullable=false)
    private String firstName;

    @Column(nullable=false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String userName;

    @Column(nullable=false)
    private Long numberProperties;

    @Column(nullable=false)
    private Long netWorth;

    public User2(String firstName, String lastName, Long numberProperties, Long netWorth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.numberProperties = numberProperties;
        this.netWorth = netWorth;
    }

    public User2(long id, String firstName, String lastName, Long numberProperties, Long netWorth) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.numberProperties = numberProperties;
        this.netWorth = netWorth;
    }

    public User2(String firstName, String lastName, String userName, Long numberProperties, Long netWorth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.numberProperties = numberProperties;
        this.netWorth = netWorth;
    }

}
