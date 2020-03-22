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

import in.nit.model.OrderMethod;
import in.nit.service.IOrderMethodService;
import in.nit.view.OrderMethodExcelView;
import in.nit.view.OrderMethodPdfView;

@RequestMapping("/om")
@Controller
public class OrderMethodController {

	@Autowired
	private IOrderMethodService service;
	
	@RequestMapping("/register")
	public String showRegisterPage(
			@ModelAttribute OrderMethod orderMethod,
			Model model)
	{
		model.addAttribute("om", orderMethod);
		return "OrderMethodRegister";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveOrderMethod(
			@ModelAttribute OrderMethod orderMethod,
			Model model)
	{
		Integer orderId = service.saveOrderMethod(orderMethod);
		model.addAttribute("message", "OrderMethod with orderId: "+orderId+" is saved");
		//clearing form backing object
		model.addAttribute("orderMethod", new OrderMethod());
		return "OrderMethodRegister";
	}
	
	@RequestMapping("/all")
	public String showAllData(Model model) {
		List<OrderMethod> list = service.getAllOrderMethods();
		model.addAttribute("list", list);
		return "OrderMethodData";
	}
	
	@RequestMapping("/view")
	public String viewOneOrderMethod(
			@RequestParam("id") Integer orderId,
			Model model
			)
	{
		model.addAttribute("om", service.getOneOrderMethod(orderId));
		return "OrderMethodView";
	}
	
	@RequestMapping("/edit")
	public String showEditPage(
			@RequestParam("id") Integer orderId,
			Model model)
	{
		model.addAttribute("orderMethod", service.getOneOrderMethod(orderId));
		return "OrderMethodEdit";
	}
	
	@RequestMapping(value="/update",method = RequestMethod.POST)
	public String updateOrderMethod(
			@ModelAttribute OrderMethod orderMethod,
			Model model)
	{
		service.updateOrderMethod(orderMethod);
		model.addAttribute("message", "OrderMethod with orderId : "+orderMethod.getOrderId()+" is succesfully updated");
		model.addAttribute("list", service.getAllOrderMethods());
		return "OrderMethodData";
	}
	
	@RequestMapping("/delete")
	public String deleteOrderMethod(
			@RequestParam("id") Integer orderId,
			Model model)
	{
		service.deleteOrderMethod(orderId);
		model.addAttribute("message", "OrderMethod with orderId : "+orderId+" is deleted");
		model.addAttribute("list", service.getAllOrderMethods());
		return "OrderMethodData";
	}
	
	@RequestMapping("/excel")
	public ModelAndView showExcel(
			@RequestParam(value="oid" ,required = false) Integer orderId
			) {
		ModelAndView m = new ModelAndView(new OrderMethodExcelView());
		if(orderId==null) {
			List<OrderMethod> list = service.getAllOrderMethods();
			m.addObject("list", list);
		}else {
			OrderMethod om = service.getOneOrderMethod(orderId);
			m.addObject("list", Arrays.asList(om));
		}
		return m;
	}
	
	@RequestMapping("/pdf")
	public ModelAndView showPdf(
			@RequestParam(value="oid",required = false) Integer orderId
			) {
		ModelAndView m = new ModelAndView(new OrderMethodPdfView());
		if(orderId==null) {
			List<OrderMethod> list = service.getAllOrderMethods();
			m.addObject("list", list);
		}else {
			OrderMethod om = service.getOneOrderMethod(orderId);
			m.addObject("list", Arrays.asList(om));
		}
		return m;
	}
}
