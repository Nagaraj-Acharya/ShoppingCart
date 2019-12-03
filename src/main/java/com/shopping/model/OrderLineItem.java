// Generated with g9.

package com.shopping.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="order_line_item")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderLineItem implements Serializable {

  
    /**
	 * 
	 */
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
    private double amount;
    @Column
    private double quantity;
    
    @ManyToOne(optional=false)
    @JoinColumn(name="product_id", nullable=false)
    private Product product;
    @ManyToOne(optional=false)
    @JoinColumn(name="subscriptin_order_id", nullable=false)
    private SubscriptionOrder subscriptionOrder;

   

}
