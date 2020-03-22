package in.nit.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import in.nit.model.OrderMethod;

public class OrderMethodExcelView extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		//dispose as dowloadable file
		response.addHeader("Content-Disposition", "attachment;filename=OrderMethodExcel.xls");
		
		//create sheet
		Sheet s = workbook.createSheet("OrderMethods");
		//create header row
		setHeader(s);
		//fetch data from model
		@SuppressWarnings("unchecked")
		List<OrderMethod> list = (List<OrderMethod>) model.get("list");
		//set data 
		setBody(s,list);
	}

	private void setBody(Sheet s, List<OrderMethod> list) {
		int count = 1;
		for(OrderMethod om : list) {
			//create a new row
			Row r = s.createRow(count++);
			r.createCell(0).setCellValue(om.getOrderId().toString());
			r.createCell(1).setCellValue(om.getOrderMode());
			r.createCell(2).setCellValue(om.getOrderCode());
			r.createCell(3).setCellValue(om.getOrderType());
			r.createCell(4).setCellValue(om.getOrderAccept().toString());
			r.createCell(5).setCellValue(om.getOrderDesc());
		}
		
	}

	private void setHeader(Sheet s) {
		//create row
		Row r = s.createRow(0);
		r.createCell(0).setCellValue("OrderId");
		r.createCell(1).setCellValue("OrderMode");
		r.createCell(2).setCellValue("OrderCode");
		r.createCell(3).setCellValue("OrderType");
		r.createCell(4).setCellValue("Accept");
		r.createCell(5).setCellValue("Description");	
	}

}
