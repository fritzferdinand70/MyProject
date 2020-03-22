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

import in.nit.model.WhUserType;

public class WhUserPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//disposing as downloadable file
				response.addHeader("Content-Disposition", "attachment;filename=OrderMethods.pdf");
				//add paragraph to document
				document.add(new Paragraph("OrderMethods"));
				
				//create table
				Table t  =new Table(8);
				t.addCell("ID");
				t.addCell("TYPE");
				t.addCell("CODE");
				t.addCell("EMAIL");
				t.addCell("CONTACT");
				t.addCell("ID TYPE");
				t.addCell("IF OTHER");
				t.addCell("ID NUMBER");
				
				//fetch data from model
				@SuppressWarnings("unchecked")
				List<WhUserType> list = (List<WhUserType>) model.get("list");
				
				//populate table with data
				for(WhUserType wh : list) {
					t.addCell(wh.getWhId().toString());
					t.addCell(wh.getUserType());
					t.addCell(wh.getUserCode());
					t.addCell(wh.getUserEmail());
					t.addCell(wh.getUserContact().toString());
					t.addCell(wh.getUserIdType());
					t.addCell(wh.getUserIdTypeOther());
					t.addCell(wh.getUserIdNumber().toString());
				}
			//add table to document
				document.add(t);
				//add date and time to documnet
				document.add(new Paragraph(new Date().toString()));

	}

}
