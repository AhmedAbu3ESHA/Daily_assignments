package com.example.HelloSpringBoot.Rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.HelloSpringBoot.Dao.NewCustomerDao;
import com.example.HelloSpringBoot.Entites.Customer;

@RestController
@RequestMapping("/customers")
public class CustomerRestController {
	

	@Autowired
	private NewCustomerDao dao;
	
	//get all
	@GetMapping("/All")
	public List<Customer> getCustomer() {
		

		return dao.findAll();
	}
	
	//getby id
	@GetMapping("/{id}")
	public Optional<Customer> getCustomer(@PathVariable(value="id") int id) {
		
		Optional<Customer> c =dao.findById(id);
		return c;
	}
	
	
	//Update & Add if same id
	@PostMapping("/add")
	public String postUpdateCustomer(@RequestBody Customer customer) {
		
		
		dao.save(customer);
		
		return "added" ;
	}

	//Delete
	@DeleteMapping("/delete/{id}")
	public String delletCustomer(@PathVariable(value="id") int id) {
		dao.deleteById(id);
		return "Deleted" ;
	}

	//get customer by fname
		@GetMapping("/name/{name}")
		public Customer findByFirstName(@PathVariable String name) {
			return dao.findByFirstName(name);
		}
		
		//get customer by fname and lname
		@GetMapping("/name/{fname}/{lname}")
		public Customer findByFirstNameOrLastName(@PathVariable String fname,@PathVariable String lname) {
			return dao.findByFirstNameOrLastName(fname,lname);
		}
		
		//get customer by  like name 
		@GetMapping("/name/like/{name}")
		public List<Customer> getCustomerByLikeName(@PathVariable String name) {
			return dao.findCustomersLikeName(name);
		}
		
	
}
