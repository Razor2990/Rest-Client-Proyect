package com.proyect.client.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	    private long id;
	    private String uid;
	    private String password;
	    private String firstName;
	    private String lastName;
	    private String thirdName;
	    private String username;
	    private String email;
	    private String avatar;
	    private String gender;
	    private String phoneNumber;
	    private String socialInsuranceNumber;
	    private Date dateOfBirth;
	    private Employment employment;
	    private Address address;
	    private CreditCard creditCard;
	    private Subscription subscription;

}
