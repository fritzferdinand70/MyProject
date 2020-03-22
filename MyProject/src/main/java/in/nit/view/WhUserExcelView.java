package in.nit.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import in.nit.model.WhUserType;

public class WhUserExcelView extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		//disposing as downloadable file
		response.addHeader("Content-Disposition", "attachment;filename=OrderMethods.xls");
		//create sheet
		Sheet s  = workbook.createSheet("OrderMethods");
		//setHeader row
		setHeader(s);
		//get data from model
		@SuppressWarnings("unchecked")
		List<WhUserType> list = (List<WhUserType>) model.get("list");
		//set data 
		setBody(s,list);

	}

	private void setBody(Sheet s, List<WhUserType> list) {
		int count=1;
		for(WhUserType wh : list) {
			Row r = s.createRow(count++);
			r.createCell(0).setCellValue(wh.getWhId().toString());
			r.createCell(1).setCellValue(wh.getUserType());
			r.createCell(2).setCellValue(wh.getUserCode());
			r.createCell(3).setCellValue(wh.getUserEmail());
			r.createCell(4).setCellValue(wh.getUserContact().toString());
			r.createCell(5).setCellValue(wh.getUserIdType());
			r.createCell(6).setCellValue(wh.getUserIdTypeOther());
			r.createCell(7).setCellValue(wh.getUserIdNumber().toString());
		}
		
	}

	private void setHeader(Sheet s) {
		Row r = s.createRow(0);
		r.createCell(0).setCellValue("ID");
		r.createCell(1).setCellValue("TYPE");
		r.createCell(2).setCellValue("CODE");
		r.createCell(3).setCellValue("EMAIL");
		r.createCell(4).setCellValue("CONTACT");
		r.createCell(5).setCellValue("ID TYPE");
		r.createCell(6).setCellValue("IF OTHER");
		r.createCell(7).setCellValue("ID NUMBER");
	}

}
