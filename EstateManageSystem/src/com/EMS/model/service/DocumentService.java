package com.EMS.model.service;

import java.util.List;

import com.EMS.model.vo.DocumentVo;

public interface DocumentService {
	public List<DocumentVo> selectDocumentAll();
	public void updateBytitle(DocumentVo housingProjectVo);
	public void deleteBytitle(String title);
	public void saveDocument(DocumentVo tb_document);

}
