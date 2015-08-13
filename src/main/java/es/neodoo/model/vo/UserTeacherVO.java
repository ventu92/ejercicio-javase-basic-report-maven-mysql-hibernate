package es.neodoo.model.vo;

public class UserTeacherVO implements java.io.Serializable {

	private Integer id;
	private TeacherVO user;
	private String centro;
	private String asignatura;

	public UserTeacherVO() {
	}

	public UserTeacherVO(String centro, String asignatura) {
		this.centro = centro;
		this.asignatura = asignatura;
	}

	public UserTeacherVO(TeacherVO user, String centro, String asignatura) {
		this.user = user;
		this.centro = centro;
		this.asignatura = asignatura;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TeacherVO getUser() {
		return this.user;
	}

	public void setUser(TeacherVO user) {
		this.user = user;
	}

	public String getCentro() {
		return this.centro;
	}

	public void setCentro(String centro) {
		this.centro = centro;
	}

	public String getAsignatura() {
		return this.asignatura;
	}

	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}

}

