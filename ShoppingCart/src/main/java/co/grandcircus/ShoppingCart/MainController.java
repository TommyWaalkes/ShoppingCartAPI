package co.grandcircus.ShoppingCart;


import java.util.List;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class MainController {

	private final CartItemsRepository repo; 
	MainController(CartItemsRepository repo) {
	    this.repo = repo;
	  }
	
	  @GetMapping("/cart-items")
	  public List<CartItems> all(){
		  return repo.findAll();
	  }
	  
	  @GetMapping("/cart-items/{id}")
	  public Optional<CartItems> getItem(@PathVariable long id) {
		  return repo.findById(id);
	  }
	  
	  @DeleteMapping("/delete/{id}")
	  public String deleteItem(@PathVariable long id) {
		  try {
			  repo.deleteById(id);
			  return "Item at id " + id + " deleted";
		  }
		  catch(Exception e) {
			  return "Item not deleted, Error: " +e.getMessage();
		  }
	  }
	  
	  @PostMapping(path="/newItem", 
			  consumes = MediaType.APPLICATION_JSON_VALUE, 
		        produces = MediaType.APPLICATION_JSON_VALUE)
	  public String newItem(@RequestBody CartItems newItem) {
		  try {
			  repo.save(newItem);
			  return newItem.getProduct() + " has been added to the database";
		  }
		  catch(Exception e) {
			  //return "There was an error, new item was not added";
			  return e.getMessage();
		  }
	  }
	  
	  @PutMapping("/updateItem/{id}")
	  public String updateItem(@PathVariable long id,@RequestBody CartItems newItem) {
		  CartItems updateItem = repo.findById(id).get();
		  updateItem.setPrice(newItem.getPrice());
		  updateItem.setProdcut(newItem.getProduct());
		  updateItem.setQuantity(newItem.getQuantity());
		  repo.save(updateItem);
		  return "Item at " + id+" updated";
	  
	  }
	  

	
}
