package in.nit.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import in.nit.model.Uom;

public class UomExcelView extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		//set file name
		response.addHeader(
				"Content-Disposition",
				"attachment;filename=Uom.xls");
		
		Sheet s = workbook.createSheet("Uoms");
		
		//construct row 0
		setHeader(s);
		//read model data
		@SuppressWarnings("unchecked")
		List<Uom> list = (List<Uom>) model.get("list");
		setBody(s,list);
		

	}

	private void setBody(Sheet s, List<Uom> list) {
		int count =1;
		for(Uom u : list) {
			Row r = s.createRow(count++);
			r.createCell(0).setCellValue(u.getUomId().toString());
			r.createCell(1).setCellValue(u.getUomType());
			r.createCell(2).setCellValue(u.getUomModel());
			r.createCell(3).setCellValue(u.getUomDesc());
		}
		
	}

	private void setHeader(Sheet s) {
		Row r = s.createRow(0);
		r.createCell(0).setCellValue("UomId");
		r.createCell(1).setCellValue("UomType");
		r.createCell(2).setCellValue("UomModel");
		r.createCell(3).setCellValue("UomDesc");
		
	}

}
