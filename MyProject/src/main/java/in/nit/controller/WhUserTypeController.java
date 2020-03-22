package in.nit.controller;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import in.nit.model.WhUserType;
import in.nit.service.IWhUserTypeService;
import in.nit.view.WhUserExcelView;
import in.nit.view.WhUserPdfView;

@RequestMapping("/wh")
@Controller
public class WhUserTypeController {

	@Autowired
	private IWhUserTypeService service;
	
	@RequestMapping("/register")
	public String showRegisterPage(
			@ModelAttribute WhUserType whUserType,
			Model model)
	{
		return "WhUserTypeRegister";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveWhUserType(
			@ModelAttribute WhUserType whUserType,
			Model model)
	{
		Integer whId = service.saveWhUserType(whUserType);
		String message = "WhUserType with whId : "+whId+"is saved";
		model.addAttribute("message", message);
		//clear form backing object
		model.addAttribute("whUserType", new WhUserType());
		return "WhUserTypeRegister";
	}
	
	@RequestMapping("/all")
	public String showAllData(Model model) {
		model.addAttribute("list", service.getAllWhUserTypes());
		return "WhUserTypeData";
	}
	
	@RequestMapping("/delete")
	public String deleteWhUserType(
			@RequestParam("wid") Integer whId,
			Model model
			)
	{
		service.deletewhUserType(whId);
		model.addAttribute("message", "WhUserType with whId : "+whId+" is deleted");
		model.addAttribute("list", service.getAllWhUserTypes());
		return "WhUserTypeData";
	}
	
	@RequestMapping("/view")
	public String viewOneWhUserType(
			@RequestParam("wid") Integer whId,
			Model model)
	{
		model.addAttribute("whOb", service.getOneWhUserType(whId));
		return "WhUserTypeView";
	}
	
	@RequestMapping("/edit")
	public String showEditPage(
			@RequestParam("wid") Integer whId,
			Model model
			) 
 	{
		model.addAttribute("whUserType", service.getOneWhUserType(whId));
		return "WhUserTypeEdit";
	}
	
	@RequestMapping( value="/update" , method = RequestMethod.POST)
	public String updateWhUserType(
			@ModelAttribute WhUserType whUserType,
			Model model)
	{
		service.updateWhUserType(whUserType);
		model.addAttribute("message", "WhUserType with whId : "+whUserType.getWhId()+" is succesfully updated");
		model.addAttribute("list", service.getAllWhUserTypes());
		return "WhUserTypeData";
	}
	
	@RequestMapping("/excel")
	public ModelAndView showExcel(
			@RequestParam(value="wid",required = false) Integer whId
			) {
		ModelAndView m = new ModelAndView(new WhUserExcelView());
		if(whId==null) {
			List<WhUserType>list = service.getAllWhUserTypes();
			m.addObject("list", list);
		}else {
			WhUserType wh = service.getOneWhUserType(whId);
			m.addObject("list", Arrays.asList(wh));
					}
		return m;
	}
	
	@RequestMapping("/pdf")
	public ModelAndView showPdf(
			@RequestParam(value = "wid",required = false) Integer whId
			) {
		ModelAndView m = new ModelAndView(new WhUserPdfView());
		if(whId==null) {
			List<WhUserType> list = service.getAllWhUserTypes();
			m.addObject("list", list);
		}else {
			WhUserType wh = service.getOneWhUserType(whId);
			m.addObject("list", Arrays.asList(wh));
		}
		return m;
	}
}
