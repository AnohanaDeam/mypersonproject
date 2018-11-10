package com.EMS.model.dao;

import java.util.List;

import com.EMS.model.vo.DocumentVo;

public interface DocumentMapper {
	/**
	 * �鿴����
	 * @return
	 */
	public List<DocumentVo> selectDocumentAll();
	/**
	 * �޸�����
	 * @param housingProjectVo
	 */
	public void updateBytitle(DocumentVo housingProjectVo);
	/**
	 * ɾ������
	 * @param title
	 */
	public void deleteBytitle(String title);
	/**
	 * ��д����
	 * @param tb_document
	 */
	public void saveDocument(DocumentVo tb_document);

}
