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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="product")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;



	/* @Column(name="LOCK_FLAG")
    private Integer lockFlag; */

    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column
    private long id;
    @Column
    private long version;
    @Column
    private String description;
    @Column
    private String name;
    @Column
    private long price;
    @OneToMany(mappedBy="product")
    private Set<OrderLineItem> orderLineItem;


}
