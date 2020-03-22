package in.nit.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

import in.nit.model.OrderMethod;

public class OrderMethodPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//set as downloadable content
		response.addHeader("Content-Disposition", "attachment;filename=OrderMethods.pdf");
		
		//add paragraph
		document.add(new Paragraph("OrderMethods PDF"));
		//create table
		Table t = new Table(6);
		t.addCell("ID");
		t.addCell("MODE");
		t.addCell("CODE");
		t.addCell("TYPE");
		t.addCell("ACCEPT");
		t.addCell("DESCRIPTION");
		
		//read data from model
		@SuppressWarnings("unchecked")
		List<OrderMethod> list = (List<OrderMethod>) model.get("list");
		//fill data into table
		for(OrderMethod om : list) {
			t.addCell(om.getOrderId().toString());
			t.addCell(om.getOrderMode());
			t.addCell(om.getOrderCode());
			t.addCell(om.getOrderType());
			t.addCell(om.getOrderAccept().toString());
			t.addCell(om.getOrderDesc());
		}
		
		//add table to document
		document.add(t);
		//add date and time
		document.add(new Paragraph(new Date().toString()));

	}

}
