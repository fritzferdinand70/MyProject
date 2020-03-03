package in.nit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import in.nit.model.ShipmentType;
import in.nit.service.IShipmentTypeService;

@Controller
@RequestMapping("/Shipment")
public class ShipmentTypeController {

	@Autowired
	IShipmentTypeService service;
	
	/*
	 * 1. showRegisterPage() GET
	 * this method shows register 
	 * page
	 */
	@RequestMapping("/register")
	public String showRegisterPage(
			@ModelAttribute ShipmentType shipmentType,
			Model model
			) {
		model.addAttribute("st",shipmentType);
		return "ShipmentTypeRegister";
	}
	
	/*
	 * This method saves one record into DB
	 * and displays the message that a record
	 * with ID was saved
	 * saveShipmentType() POST
	 */
	@RequestMapping(value = "/save" ,method = RequestMethod.POST)
	public String saveShipmentType(
			@ModelAttribute ShipmentType shipmentType,
			Model model) {
		Integer id = service.saveShipmentType(shipmentType);
		String message = "Shipment Type with id : "+id+" saved";
		model.addAttribute("message", message);
		model.addAttribute("st",shipmentType);
		return"ShipmentTypeRegister";
	}
	
	/*
	 * This method shows all data in the table
	 * showAll() GET
 	 */
	
	@RequestMapping("/all")
	public String showAll(Model model) {
		List<ShipmentType> list = service.getAllShipmentTypes();
		model.addAttribute("list", list);
		return "ShipmentTypeData";
	}
	
	/*
	 * This method delete row based on id
	 * It uses concept of url rewriting
	 * the request param will be sid
	 * deleteShipmentType() GET
	 */
	@RequestMapping("/delete")
	public String deleteShipmentType(
			@RequestParam Integer sid,
			Model model)
	{
		service.deleteShipmentType(sid);
		String message = "ShipmentType with id : " + sid +" deleted";
		model.addAttribute("message", message);
		
		//show remaining data
		List<ShipmentType> list = service.getAllShipmentTypes();
		model.addAttribute("list", list);
		return "ShipmentTypeData";
	}
	
	/*
	 * This method shows an edit page
	 * with the details of the row filled
	 * to be modified
	 * showEditPage() GET
	 */
	@RequestMapping("/edit")
	public String showEditPage(
			@RequestParam Integer sid,
			Model model)
	{
		ShipmentType st = service.getOneShipmentType(sid);
		model.addAttribute("shipmentType", st);
		return "ShipmentTypeEdit";
	}
	
	/**
	 * This method submits the modified records
	 * of a row and modifies the data In DB
	 * using id
	 * updateShipmentType() POST
	 */
	@RequestMapping("/update")
	public String updateShipmentType(
			@ModelAttribute ShipmentType shipmentType,
			Model model)
	{
		service.updateShipmentType(shipmentType);
		String message = "ShipmentType with id : "+shipmentType.getShipId()+ " updated";
		model.addAttribute("message", message);
		//displaying updated set of records
		List<ShipmentType> list = service.getAllShipmentTypes();
		model.addAttribute("list", list);
		return "ShipmentTypeData";	
	}
	
	/*
	 * this method gives a view of a single row 
	 * based on id
	 * showOneShipment() GET
	 */
	
	@RequestMapping("/view")
	public String showOneShipment(
			@RequestParam Integer sid,
			Model model) 
	{
		ShipmentType st = service.getOneShipmentType(sid);
		model.addAttribute("ob", st);
		return "ShipmentTypeView";
	}
}
