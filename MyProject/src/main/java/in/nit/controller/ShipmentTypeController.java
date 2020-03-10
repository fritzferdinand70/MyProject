package in.nit.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.nit.model.ShipmentType;
import in.nit.service.IShipmentTypeService;
import in.nit.util.ShipmentTypeUtil;
import in.nit.view.ShipmentTypeExcelView;
import in.nit.view.ShipmentTypePdfView;

@Controller
@RequestMapping("/shipment")
public class ShipmentTypeController {

	@Autowired
	private IShipmentTypeService service;
	
	@Autowired
	private ServletContext context;
	@Autowired
	private ShipmentTypeUtil util;
	
	/* method no-1
	 * showRegisterPage() GET
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
	
	/*method no-2
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
	
	/*method no-3
	 * This method shows all data in the table
	 * showAll() GET
 	 */
	
	@RequestMapping("/all")
	public String showAll(Model model) {
		List<ShipmentType> list = service.getAllShipmentTypes();
		model.addAttribute("list", list);
		return "ShipmentTypeData";
	}
	
	/*method no-4
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
	
	/*method no-5
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
	
	/**  method no-6
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
	
	/* method no-7
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
	
	/*method no-8
	 * this method fetches all rows from DB
	 * and returns a ModelAndView Object
	 * which contains data ie model
	 * and an implementation of View
	 * Now View presents the model as specifed
	 */
	@RequestMapping("/excel")
	public ModelAndView showExcel(
			@RequestParam(value = "id",required=false) Integer id
			)
	{
		ModelAndView m = new ModelAndView();
		m.setView(new ShipmentTypeExcelView());
		if(id==null) {
		//fetching data from db
		List<ShipmentType> list = service.getAllShipmentTypes();
		m.addObject("list", list);
		}else {
			ShipmentType st = service.getOneShipmentType(id);
			m.addObject("list", Arrays.asList(st));
					
		}
		
		return m;
	}
	
	/*
	 * method--9
	 * this method fetches data from db and return model and view
	 * and gives pdf to download
	 * 
	 */
	@RequestMapping("/pdf")
	public ModelAndView showPdf(
			@RequestParam(value="id",required = false) Integer id
			) {
		ModelAndView m = new ModelAndView();
		m.setView(new ShipmentTypePdfView());
		
		if(id==null) {
			List<ShipmentType> list = service.getAllShipmentTypes();
			m.addObject("list", list);
		}
		else {
			ShipmentType st = service.getOneShipmentType(id);
			m.addObject("list", Arrays.asList(st));
		}
		return m;
	}
	
	/*
	 * method 10
	 * this method gathers List<Object[]> 
	 * in key value pair of (ShipmentMode,count)
	 * and converts it appropriate images 
	 * using util class and returns chartsview.jsp
	 * page
	 */
	@RequestMapping("/charts")
	public String showCharts() {
		List<Object[]> list = service.getShipmentModeCount();
		String path = context.getRealPath("/");
		util.generatePie(path, list);
		util.generateBar(path, list);
		return "ShipmentTypeCharts";
	}
}
