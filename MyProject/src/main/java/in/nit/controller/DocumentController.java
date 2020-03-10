package in.nit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import in.nit.model.Document;
import in.nit.service.IDocumentService;

@Controller
@RequestMapping("/docs")
public class DocumentController {

	@Autowired
	private IDocumentService service;
	
	/*
	 * This methods shows document upload page
	 */
	
	@RequestMapping("/show")
	public String showUploadPage(
			HttpServletRequest request,
			Model model) {
		List<Object[]> list = service.getFileIdAndNames();
		model.addAttribute("list", list);
		//getting id from request parameter
		if(request.getAttribute("id")!=null) {
			String id = (String)request.getAttribute("id");
		String msg = "file with "+id+" is uploaded";
		model.addAttribute("message",msg);
		}
		return "Documents";
	}
	
	/*
	 * This method upload the doc that just
	 * has been sent from Documents.jsp page
	 * into DB
	 */
	 
	@RequestMapping(value= "/upload",method = RequestMethod.POST)
	public String uploadDoc(
			@RequestParam Integer fileId,
			@RequestParam CommonsMultipartFile fileOb,
			HttpServletRequest request,
			Model model
			)
	
	{
		Integer id = null;
		if(fileOb!=null){
		Document doc = new Document();
		doc.setFileId(fileId);
		doc.setFileName(fileOb.getOriginalFilename());
		doc.setFileData(fileOb.getBytes());
		
	    id = service.saveDocument(doc);
		//String msg = fileId + " is uploaded";
	//	model.addAttribute("message", msg);
	}	
		request.setAttribute("id", id);
		//redirecting to /show URL
		return "redirect:show";
	}
	/*
	 * this method returns document record data 
	 * by urlRewriting taking the file id
	 * gives the file as a downloadable file
	 */
	@RequestMapping("/download")
	public void downloadDoc(
			@RequestParam Integer fid,
			HttpServletResponse response
			) 
	{
	//get document based on  ID
		Document doc = service.getOneDocument(fid);
		response.addHeader("Content-Disposition",
				"attachment;fileName = "+doc.getFileName());
		try {
			//copy data to OS
			FileCopyUtils.copy(
					doc.getFileData(),
					response.getOutputStream()
					);
		}catch(IOException io){
			io.printStackTrace();
		}
		
	}
	
}
