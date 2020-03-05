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

import in.nit.model.ShipmentType;

public class ShipmentTypePdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//dispose as download file
		response.addHeader("Content-Disposition", "filename;shipments.pdf");
		
		Paragraph p = new Paragraph("Welcome to Shipments Type");
		
		//add paragarph to document
		document.add(p);
		 
		 //fetch data from model
		 @SuppressWarnings("unchecked")
		List<ShipmentType> list = (List<ShipmentType>) model.get("list");
		
		 //create table
		 Table table  =new Table(6);
		 table.addCell("ID");
		 table.addCell("MODE");
		 table.addCell("CODE");
		 table.addCell("ENABLE");
		 table.addCell("GRADE");
		 table.addCell("NOTE");
	
		 //adding data to table
		 for(ShipmentType st : list) {
			 table.addCell(st.getShipId().toString());
			 table.addCell(st.getShipMode());
			 table.addCell(st.getShipCode());
			 table.addCell(st.getEnbShip());
			 table.addCell(st.getShipGrade());
			 table.addCell(st.getShipDesc());
		 }
		 
		 //add table to document
		 document.add(table);
		 //print date and time
		 document.add(new Paragraph(new Date().toString()));
	}


}
