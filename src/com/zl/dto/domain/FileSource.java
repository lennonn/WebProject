package com.zl.dto.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * File entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "FILES", schema = "SCOTT")
public class FileSource implements java.io.Serializable {

	// Fields

	private String fileId;
	private Category category;
	private String fileName;
	private String fileSize;
	private String catagoryId;
	private Date updateDate;
	private String updateUser;
	private Date uploadDate;
	private String uploadUser;
	private String fileUrl;
	private Date downloadDate;
	private Date downloadUser;

	// Constructors

	/** default constructor */
	public FileSource() {
	}

	/** minimal constructor */
	public FileSource(Category category, String fileName, String fileSize,
			String catagoryId, String uploadUser, String fileUrl) {
		this.category = category;
		this.fileName = fileName;
		this.fileSize = fileSize;
		this.catagoryId = catagoryId;
		this.uploadUser = uploadUser;
		this.fileUrl = fileUrl;
	}

	/** full constructor */
	public FileSource(Category category, String fileName, String fileSize,
			String catagoryId, Date updateDate, String updateUser,
			Date uploadDate, String uploadUser, String fileUrl,
			Date downloadDate, Date downloadUser) {
		this.category = category;
		this.fileName = fileName;
		this.fileSize = fileSize;
		this.catagoryId = catagoryId;
		this.updateDate = updateDate;
		this.updateUser = updateUser;
		this.uploadDate = uploadDate;
		this.uploadUser = uploadUser;
		this.fileUrl = fileUrl;
		this.downloadDate = downloadDate;
		this.downloadUser = downloadUser;
	}

	// Property accessors
	@SequenceGenerator(name = "generator")
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "generator")
	@Column(name = "FILE_ID", unique = true, nullable = false, length = 10)
	public String getFileId() {
		return this.fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CATEGORY_ID", nullable = false)
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Column(name = "FILE_NAME", nullable = false, length = 30)
	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Column(name = "FILE_SIZE", nullable = false, length = 10)
	public String getFileSize() {
		return this.fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	@Column(name = "CATAGORY_ID", nullable = false, length = 10)
	public String getCatagoryId() {
		return this.catagoryId;
	}

	public void setCatagoryId(String catagoryId) {
		this.catagoryId = catagoryId;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATE_DATE", length = 7)
	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Column(name = "UPDATE_USER", length = 20)
	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "UPLOAD_DATE", length = 7)
	public Date getUploadDate() {
		return this.uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	@Column(name = "UPLOAD_USER", nullable = false, length = 10)
	public String getUploadUser() {
		return this.uploadUser;
	}

	public void setUploadUser(String uploadUser) {
		this.uploadUser = uploadUser;
	}

	@Column(name = "FILE_URL", nullable = false, length = 10)
	public String getFileUrl() {
		return this.fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DOWNLOAD_DATE", length = 7)
	public Date getDownloadDate() {
		return this.downloadDate;
	}

	public void setDownloadDate(Date downloadDate) {
		this.downloadDate = downloadDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DOWNLOAD_USER", length = 7)
	public Date getDownloadUser() {
		return this.downloadUser;
	}

	public void setDownloadUser(Date downloadUser) {
		this.downloadUser = downloadUser;
	}

}