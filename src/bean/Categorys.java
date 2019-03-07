package bean;

import java.io.Serializable;

public class Categorys implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String description;
	private String created_at;
	
	public Categorys() {
		super();
	}

	public Categorys(String id, String name, String description, String created_at) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.created_at = created_at;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

}
