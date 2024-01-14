package com.romeoscode.accounts.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

/**
 * @author romeo.jerenyama
 * @created 02/01/2024 - 18:12
 */
@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native")
    @Column(name = "customer_id")
    private Long customerId;

    private String name;

    @Email
    private String email;

    @Column(name = "mobile_number")
    private String mobileNumber;
}
