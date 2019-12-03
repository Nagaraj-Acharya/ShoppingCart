package com.shopping.model;
import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;



	/*
	 * @Column(name="LOCK_FLAG") private Integer lockFlag;
	 */

    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column
    private long id;
    @Column
    private long version;
    @Column
    private String email;
    @Column
    private String name;
    @OneToMany(mappedBy="customer")
    private Set<SubscriptionOrder> subscriptionOrder;

   

}