package net.ray.web.ees.eo;

import java.util.Date;

public class BaseEO {
	private Integer id;
	private Date creationDate;
	private String createdBy;
	private Date updateDate;
	private String updatedBy;
	private int isAlive;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public int getIsAlive() {
		return isAlive;
	}
	public void setIsAlive(int isAlive) {
		this.isAlive = isAlive;
	}
	
}
