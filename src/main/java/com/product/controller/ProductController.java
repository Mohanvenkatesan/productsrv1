package com.product.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.dto.ProductDTO;

@RestController
@Component
@CrossOrigin(origins = "*")
public class ProductController {

	public ProductController() {
	}

	@RequestMapping(value = "/getAllProducts", method = RequestMethod.GET)
	public @ResponseBody List<ProductDTO> getAllProducts(){
		return defineProducts();
	}	
	
	@RequestMapping(value = "/getProductByType", method = RequestMethod.GET)
	public @ResponseBody List<ProductDTO> getProductByType(@RequestParam("type") String type){
		return filterProducts(type);
	}	
	
	private List<ProductDTO> filterProducts(String type){
		List<ProductDTO> filteredProducts = new ArrayList<ProductDTO>();
		
		List<ProductDTO> allProducts = defineProducts();
		Iterator<ProductDTO> iterator = allProducts.iterator();
		while(iterator.hasNext()){
			ProductDTO productDTO = iterator.next();
			if(type.equalsIgnoreCase(productDTO.getType())){
				filteredProducts.add(productDTO);
			}
		}
		
		return filteredProducts;
	}
	
	private List<ProductDTO> defineProducts(){
		List<ProductDTO> products = new ArrayList<ProductDTO>();
		
		ProductDTO productDTO1 = new ProductDTO();
		productDTO1.setId("1");
		productDTO1.setCode("ROT");
		productDTO1.setType("WIRELESS");
		productDTO1.setName("Router");
		productDTO1.setPrice(1000);
		products.add(productDTO1);

		ProductDTO productDTO2 = new ProductDTO();
		productDTO2.setId("2");
		productDTO2.setCode("MOD");
		productDTO2.setType("WIRELESS");
		productDTO2.setName("Modem");
		productDTO2.setPrice(2000);
		products.add(productDTO2);

		ProductDTO productDTO3 = new ProductDTO();
		productDTO3.setId("3");
		productDTO3.setCode("CAB");
		productDTO3.setType("WIRED");
		productDTO3.setName("Cable");
		productDTO3.setPrice(500);
		products.add(productDTO3);

		ProductDTO productDTO4 = new ProductDTO();
		productDTO4.setId("4");
		productDTO4.setCode("ADA");
		productDTO4.setType("WIRELESS");
		productDTO4.setName("ADAPTER");
		productDTO4.setPrice(1500);
		products.add(productDTO4);

		ProductDTO productDTO5 = new ProductDTO();
		productDTO5.setId("1");
		productDTO5.setCode("LL");
		productDTO5.setType("WIRED");
		productDTO5.setName("Landline");
		productDTO5.setPrice(700);
		products.add(productDTO5);
		
		return products;

	}
}
