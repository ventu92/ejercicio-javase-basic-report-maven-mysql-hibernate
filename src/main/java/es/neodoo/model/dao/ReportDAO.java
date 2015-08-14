package es.neodoo.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import es.neodoo.model.vo.User;
import es.neodoo.model.vo.UserTeacher;
import es.neodoo.service.OperationDB;
import es.neodoo.util.HibernateUtil;

public class ReportDAO extends OperationDB {
	
	private Connection conexion = null;
	
	private OperationDB operationDB = null;

	public List<User> getLstTeacher() {

		List<User> teachers = new ArrayList();
		
		try {
			// Se realiza la consulta. Los resultados se guardan en el
			Statement s = (Statement) conexion.createStatement();

			ResultSet rs = s.executeQuery("select * from user");

			// Se recorre el ResultSet, mostrando por pantalla los resultados.
			while (rs.next()) {

				User teacher = null;

				teacher = new User(rs.getString(1), rs.getString(3), rs.getString(4));
				teachers.add(teacher);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return teachers;

	}

	public void insertTeachers() {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
	        
	        session.beginTransaction();

	        User teacher = new User();

			teacher.setId(1);
			teacher.setNombre("aaa");
			teacher.setApellidos("bbb");
			teacher.setDni("123456789K");

			UserTeacher userTeachersVO = new UserTeacher();
			userTeachersVO.setId(1);
			userTeachersVO.setCentro("Salesianos");
			userTeachersVO.setAsignatura("Matematicas");

			teacher.getUserTeachers().add(userTeachersVO);
			
			session.save(teacher);
			session.getTransaction().commit();
			
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		System.out.println("insert complete");
	}

	public void initConection() {

		OperationDB operationDB = new OperationDB();
		this.conexion = operationDB.conectar();
	}

	public void closeConection() {
		operationDB.desconectar(conexion);
	}

	public void CallableStatement() {

		try {
			// Creamos la conexion
			conexion.setAutoCommit(false);

			java.sql.CallableStatement cStmt = conexion.prepareCall("{CALL get_user_teacher(?,?)}");
			cStmt.setString(1, "Salesianos");
			cStmt.registerOutParameter(2, java.sql.Types.INTEGER);

			// execute getDBUSERByUserId store procedure
			cStmt.executeUpdate();

			int resultado = cStmt.getInt(2);
			System.out.println("El resultado de la llamada es: "+resultado);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
