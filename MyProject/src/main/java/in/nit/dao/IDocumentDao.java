package in.nit.dao;

import java.util.List;

import in.nit.model.Document;

public interface IDocumentDao {

	Integer saveDocument(Document doc);
	List<Object[]> getFileIdAndNames();
	Document getOneDocument(Integer fid);
}
