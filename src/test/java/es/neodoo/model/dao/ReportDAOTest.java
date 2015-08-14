package es.neodoo.model.dao;

import java.util.List;

import es.neodoo.model.vo.User;
import junit.framework.TestCase;

public class ReportDAOTest extends TestCase {

	public void testGetLstTeacher() {
		
		ReportDAO reportDAO = new ReportDAO();
		List<User> teachers = reportDAO.getLstTeacher();

		assertNotNull(teachers);
		
	}

}
