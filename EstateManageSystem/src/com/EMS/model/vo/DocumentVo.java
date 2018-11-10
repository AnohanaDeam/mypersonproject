package com.EMS.model.vo;

import java.util.Date;

/**
 * �����
 * @author JTXY
 *
 */
public class DocumentVo {
	/**
	 * �ļ�ͷ
	 */
	private String file_header;
	/**
	 * �ֺ�
	 */
	private double word_size;
	/**
	 * ����
	 */
	private String title;
	/**
	 * �շ�����
	 */
	private Date sr_time;
	/**
	 * �浵λ��
	 */
	private String archive_location;
	/**
	 * �����
	 */
	private String subject_term;
	/**
	 * ����
	 */
	private String send;
	public String getFile_header() {
		return file_header;
	}
	public void setFile_header(String file_header) {
		this.file_header = file_header;
	}
	public double getWord_size() {
		return word_size;
	}
	public void setWord_size(double word_size) {
		this.word_size = word_size;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getSr_time() {
		return sr_time;
	}
	public void setSr_time(Date sr_time) {
		this.sr_time = sr_time;
	}
	public String getArchive_location() {
		return archive_location;
	}
	public void setArchive_location(String archive_location) {
		this.archive_location = archive_location;
	}
	public String getSubject_term() {
		return subject_term;
	}
	public void setSubject_term(String subject_term) {
		this.subject_term = subject_term;
	}
	public String getSend() {
		return send;
	}
	public void setSend(String send) {
		this.send = send;
	}
	@Override
	public String toString() {
		return "DocumentVo [file_header=" + file_header + ", word_size=" + word_size + ", title=" + title + ", sr_time="
				+ sr_time + ", archive_location=" + archive_location + ", subject_term=" + subject_term + ", send="
				+ send + "]";
	}
	public DocumentVo(String file_header, double word_size, String title, Date sr_time, String archive_location,
			String subject_term, String send) {
		super();
		this.file_header = file_header;
		this.word_size = word_size;
		this.title = title;
		this.sr_time = sr_time;
		this.archive_location = archive_location;
		this.subject_term = subject_term;
		this.send = send;
	}
	public DocumentVo() {
		super();
	}
	
	

}
