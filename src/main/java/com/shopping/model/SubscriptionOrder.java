// Generated with g9.

package com.shopping.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="subscription_order")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubscriptionOrder implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * @Column(name="LOCK_FLAG") private Integer lockFlag; public void
	 * setLockFlag(Integer aLockFlag) { lockFlag = aLockFlag; }
	 */

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column
    private long id;
    
    @Column
    private long version;
    
    @Column
    private double total;
    
    @ManyToOne(optional=false)
    @JoinColumn(name="customer_id", nullable=false)
    private Customer customer;
    
    @OneToMany(mappedBy="subscriptionOrder")
    private Set<OrderLineItem> orderLineItem;

    
    

}
