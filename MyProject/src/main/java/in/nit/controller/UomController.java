package in.nit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import in.nit.model.Uom;
import in.nit.service.IUomService;

@RequestMapping("/uom")
@Controller
public class UomController {

	@Autowired
	private IUomService service;
	
	@RequestMapping("/register")
	public String showRegisterPage(
			@ModelAttribute Uom uomOb,
			Model model) {
		model.addAttribute("uomOb", uomOb);
		return "UomRegister";
	}
	
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public String saveUom(
			@ModelAttribute Uom uomOb,
			Model model)
	{
		Integer id = service.saveUom(uomOb);
		String msg = "Uom with id :"+id+" saved";
		model.addAttribute("uomOb", new Uom());
		model.addAttribute("message", msg);
		return "UomRegister";
	}
	
	@RequestMapping("/all")
	public String showAllUoms(Model model) {
		List<Uom> list = service.getAllUoms();
		model.addAttribute("list",list);
		return "UomData";
	}
	
	@RequestMapping("/view")
	public String viewOneUom(
			@RequestParam("uid") Integer uomId,
			Model model) 
	{
		Uom uomOb = service.getOneUom(uomId);
		model.addAttribute("ob", uomOb);
		return "UomView";
	}
	
	@RequestMapping("/delete")
	public String deleteUom(
			@RequestParam("uid") Integer uomId,
			Model model)
	{
		service.deleteUom(uomId);
		List<Uom> list = service.getAllUoms();
		model.addAttribute("list", list);
		model.addAttribute("message", "Uom with id: "+uomId+" is deleted");
		return "UomData";
	}
	
	@RequestMapping("/edit")
	public String showEditPage(
			@RequestParam("uid") Integer uomId,
			Model model)
	{
		Uom uomOb = service.getOneUom(uomId);
		model.addAttribute("uomOb", uomOb);
		return "UomEdit";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updateUom(
			@ModelAttribute Uom uomOb,
			Model model)
	{
		service.updateUom(uomOb);
		//retrieve data
		List<Uom> list = service.getAllUoms();
		model.addAttribute("list", list);
		model.addAttribute("message", "Uom with id: "+uomOb.getUomId()+" is updated");
		return "UomData";
	}
	
}
