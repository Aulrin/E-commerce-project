package com.niit.shoppingcart.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shopingcart.dao.SupplierDAO;
import com.niit.shopingcart.domain.Supplier;

@Controller//Request handler
public class SupplierController {
	
	@Autowired
	private SupplierDAO supplierDAO;

	@Autowired
	private Supplier supplier;

	@Autowired
	HttpSession httpSession;

	@PostMapping("/supplier/save/")

	public ModelAndView saveSupplier(@RequestParam("id") String id,
			@RequestParam("name") String name,
			@RequestParam("address") String address) {
System.out.println("saveSupplier method is calling");
		ModelAndView mv = new ModelAndView("redirect:/managesuppliers");
		supplier.setId(id);
		supplier.setName(name);
		supplier.setAddress(address);
		if (supplierDAO.save(supplier)) {
			mv.addObject("supplierSuccessMessage", "The supplier created successfully");
		} else {
			mv.addObject("supplierErrorMessage", "Coulc not able to create supplier.  please contact admin");
		}
		httpSession.removeAttribute("selectedSupplier");
		return mv;

	}

	@PutMapping("/supplier/update/")
	public ModelAndView updateSupplier(@ModelAttribute Supplier supplier) {
		// navigate to home page
		ModelAndView mv = new ModelAndView("home");

		
		if (supplierDAO.update(supplier) == true) {
			// add success message
			mv.addObject("successMessage", "The supplier updated successfully");
		} else {
			// add failure message
			mv.addObject("errorMessage", "Could not update the supplier.");

		}
		httpSession.removeAttribute("selectedSupplier");
		return mv;

	}

	@GetMapping("/supplier/delete/")
	public ModelAndView deleteSupplier(@RequestParam String id) {
		// navigate to home page
		ModelAndView mv = new ModelAndView("redirect:/managesuppliers");
		// we supposed to fetch the latest categories
		// and add to httpSession
	
		if (supplierDAO.delete(id) == true) {
			// add success message
			mv.addObject("supplierSuccessMessage", "The supplier deleted successfully");

		} else {
			// add failure message
			mv.addObject("supplierErrorMessage", "Could not delete the supplier.");

		}

		return mv;

	}

	@GetMapping("/supplier/edit/")
	public ModelAndView editSupplier(@RequestParam String id) {
		ModelAndView mv = new ModelAndView("redirect:/managesuppliers");
		
		supplier = supplierDAO.get(id);
		
		httpSession.setAttribute("selectedSupplier", supplier);

		return mv;
	}

	@GetMapping("/suppliers")
	public ModelAndView getAllSuppliers() {
		ModelAndView mv = new ModelAndView("home");
		List<Supplier> suppliers = supplierDAO.list();
		mv.addObject("suppliers", suppliers);
		return mv;
	}

}
