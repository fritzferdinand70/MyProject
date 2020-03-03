package in.nit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Shipment")
public class ShipmentTypeController {

	/*
	 * 1. showRegisterPage()
	 * this method shows register 
	 * page
	 */
	@RequestMapping("/register")
	public String showRegisterPage() {
		return "ShipmentTypeRegister";
	}
}
