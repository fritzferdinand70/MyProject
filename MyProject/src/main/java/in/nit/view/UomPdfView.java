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

import in.nit.model.Uom;

public class UomPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//dispose as downloadable file
		response.addHeader("Content-Disposition", "attachment;filename=UomsPDF.pdf");
		
		//create paragraph
		Paragraph p = new Paragraph("UomsPDF");
		//add paragraph
		document.add(p);
		
		//create table
		Table t = new Table(4);
		t.addCell("UomId");
		t.addCell("UomType");
		t.addCell("UomModel");
		t.addCell("UomDesc");

		//read data and add to table
		@SuppressWarnings("unchecked")
		List<Uom> list = (List<Uom>) model.get("list");
		for(Uom u :list) {
			t.addCell(u.getUomId().toString());
			t.addCell(u.getUomType());
			t.addCell(u.getUomModel());
			t.addCell(u.getUomDesc());
		}
		
		//add table to document
		document.add(t);
		
		//print date and time
		document.add(new Paragraph(new Date().toString()));
		

	}

}
