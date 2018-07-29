package com.football.model.futsal.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.football.model.futsal.dao.FutsalDAO;
import com.football.model.futsal.dto.FutsalDTO;
import com.football.model.futsal.dto.FutsalFacilitiesDTO;
import com.football.model.futsal.dto.FutsalImageDTO;
import com.football.model.futsal.dto.FutsalPPHDTO;
import com.football.model.futsal.dto.FutsalRentalDTO;

@Service
public class FutsalServiceImpl implements FutsalService {

	@Autowired
	FutsalDAO futsalDAO;

	@Transactional
	@Override
	public void insertFutsal(FutsalDTO futsalDTO, FutsalFacilitiesDTO futsalFacilitiesDTO,
			FutsalRentalDTO futsalRentalDTO, FutsalPPHDTO futsalPPHDTO, FutsalImageDTO futsalImageDTO, String imgPath,
			List<MultipartFile> mf) throws Exception {

		int futsalNo = futsalDAO.selectFutsalNo();
		futsalDTO.setFutsalNo(futsalNo);
		futsalFacilitiesDTO.setFutsalNo(futsalNo);
		futsalRentalDTO.setFutsalNo(futsalNo);
		futsalPPHDTO.setFutsalNo(futsalNo);
		futsalImageDTO.setFutsalNo(futsalNo);

		futsalDAO.insertFutsal(futsalDTO);
		futsalDAO.insertFutsalFacilities(futsalFacilitiesDTO);
		futsalDAO.insertFutsalRental(futsalRentalDTO);
		futsalDAO.insertFutsalPPH(futsalPPHDTO);

		/** �̹��� ���ε� */
		MultipartFile file = null;
		String originalFilename = null; // �������� ���� �̸�
		String fileName = null; // �����̸� �ߺ� �������� �ٲ� �̸�(����� �̸�)
		double fileSize = 0; // ���� ������
		// String fileExtension = null; // ���� Ȯ����
		int fileCnt = mf.size(); // ���� ����

		for (int i = 0; i < mf.size(); i++) {

			file = mf.get(i);

			futsalImageDTO.setFiles(mf.get(i));

			originalFilename = mf.get(i).getOriginalFilename();
			fileName = System.currentTimeMillis() + "_" + originalFilename;
			fileSize = mf.get(i).getSize();
			// fileExtension = FilenameUtils.getExtension(originalFilename).toLowerCase();

			futsalImageDTO.setFutsalImagePath(fileName);

			// DAO ȣ��
			int resultParkImg = futsalDAO.insertImg(futsalImageDTO);
			if (resultParkImg == 0) {
				throw new RuntimeException();
			}

			file.transferTo(new File(imgPath + "/" + fileName));// �̹��� ����
		}
	}

	@Override
	public List<FutsalDTO> selectFutsalListPage(int offset, int noOfRecords) {
		return futsalDAO.selectFutsalListPage(offset, noOfRecords);
	}

	@Override
	public int selectFutsalCount() {
		return futsalDAO.selectfutsalCount();
	}

	@Override
	public FutsalDTO selectFutsalOne(int futsalNo) {
		return futsalDAO.selectFutsalOne(futsalNo);
	}
}
