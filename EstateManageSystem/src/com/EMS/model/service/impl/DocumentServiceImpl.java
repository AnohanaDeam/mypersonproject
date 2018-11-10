package com.EMS.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EMS.model.dao.DocumentMapper;
import com.EMS.model.service.DocumentService;
import com.EMS.model.vo.DocumentVo;
@Service
public class DocumentServiceImpl implements DocumentService {
@Autowired
private DocumentMapper documentmapper;
	@Override
	/**
	 * �鿴����
	 */
	public List<DocumentVo> selectDocumentAll() {
		// TODO Auto-generated method stub
		return documentmapper.selectDocumentAll();
	}

	@Override
	/**
	 * �޸�����
	 */
	public void updateBytitle(DocumentVo housingProjectVo) {
		// TODO Auto-generated method stub
		documentmapper.updateBytitle(housingProjectVo);
	}

	@Override
	/**
	 * ɾ������
	 */
	public void deleteBytitle(String title) {
		// TODO Auto-generated method stub
		documentmapper.deleteBytitle(title);
	}

	@Override
	/**
	 * ��д����
	 */
	public void saveDocument(DocumentVo tb_document) {
		// TODO Auto-generated method stub
		documentmapper.saveDocument(tb_document);
	}

}
