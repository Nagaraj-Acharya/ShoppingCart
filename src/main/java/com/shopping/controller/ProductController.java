package com.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.shopping.jsonconvertor.Item;
import com.shopping.jsonconvertor.Shopping;
import com.shopping.model.Customer;
import com.shopping.model.OrderLineItem;
import com.shopping.model.Product;
import com.shopping.model.SubscriptionOrder;
import com.shopping.repository.CustomerRepository;
import com.shopping.repository.OrderLineItemRepository;
import com.shopping.repository.ProductRepository;
import com.shopping.repository.SubscriptionOrderRepository;

@RestController
public class ProductController {

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	SubscriptionOrderRepository subscriptionOrderRepository;
	
	
	@Autowired
	OrderLineItemRepository orderLineItemRepository;
	
	
	
	@PostMapping("/saving") 
	public ResponseEntity<Object> saveProducts(@RequestBody String shopping) {
		
		System.out.println(".....");
		Gson gson = new Gson(); 
		
      
		
		Shopping shopObj = gson.fromJson(shopping,Shopping.class); 
			
		String email= shopObj.getEmail();
		String name= shopObj.getName();
		 
		Customer customer=new Customer();
		
			customer.setEmail(email);
			customer.setName(name);
			customer.setVersion(1);
			customer=customerRepository.save(customer);
		
		
	
		
		SubscriptionOrder subscriptionOrder=new SubscriptionOrder();
		
		subscriptionOrder.setVersion(2);
		subscriptionOrder.setCustomer(customer);
		subscriptionOrder = subscriptionOrderRepository.save(subscriptionOrder);
		
		double ToatalPrice=0;
		List<Item> itemsList=shopObj.getItems();
		
		
		
		//orderid..customer.
		//
		double OrdTot=0.0;
		
		for (Item item : itemsList) {
			
			long ProductId=item.getProductId();
			Product product = productRepository.productFindByID(ProductId);
			if(product!=null)
			{
			long productPrice= product.getPrice();
			
			ToatalPrice= productPrice * item.getQuantity();
			OrdTot=OrdTot+ToatalPrice;
			System.err.println("ToatalPrice" + ToatalPrice);
			
			OrderLineItem orderLineItem =new OrderLineItem();
			orderLineItem.setAmount(ToatalPrice);
			orderLineItem.setProduct(product);
			orderLineItem.setSubscriptionOrder(subscriptionOrder);
			orderLineItem.setQuantity(item.getQuantity());
			orderLineItemRepository.save(orderLineItem);
			}
			subscriptionOrder.setTotal(OrdTot);
			subscriptionOrderRepository.save(subscriptionOrder);
		}
		 
		
		
		return new ResponseEntity<Object>("success" , HttpStatus.OK);
	
	}
}
