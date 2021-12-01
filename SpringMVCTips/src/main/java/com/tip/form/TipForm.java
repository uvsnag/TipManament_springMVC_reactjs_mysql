package com.tip.form;

public class TipForm {
	private Integer id;
	private String name;
	private String contents;
	private Integer idType;
	private String deleteDate;
	private String updateDate;
	private String typeUpdate;
	
	public TipForm() {
		super();
	}
	
	public String getTypeUpdate() {
		return typeUpdate;
	}

	public void setTypeUpdate(String typeUpdate) {
		this.typeUpdate = typeUpdate;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Integer getIdType() {
		return idType;
	}
	public void setIdType(Integer idType) {
		this.idType = idType;
	}
	public String getDeleteDate() {
		return deleteDate;
	}
	public void setDeleteDate(String deleteDate) {
		this.deleteDate = deleteDate;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	

}
