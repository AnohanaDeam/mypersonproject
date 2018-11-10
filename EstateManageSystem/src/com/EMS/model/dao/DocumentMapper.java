package com.EMS.model.dao;

import java.util.List;

import com.EMS.model.vo.DocumentVo;

public interface DocumentMapper {
	/**
	 * 查看文书
	 * @return
	 */
	public List<DocumentVo> selectDocumentAll();
	/**
	 * 修改文书
	 * @param housingProjectVo
	 */
	public void updateBytitle(DocumentVo housingProjectVo);
	/**
	 * 删除文书
	 * @param title
	 */
	public void deleteBytitle(String title);
	/**
	 * 填写文书
	 * @param tb_document
	 */
	public void saveDocument(DocumentVo tb_document);

}
