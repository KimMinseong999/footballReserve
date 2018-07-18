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

		/** 이미지 업로드 */
		MultipartFile file = null;
		String originalFilename = null; // 오리지널 파일 이름
		String fileName = null; // 파일이름 중복 막기위해 바꾼 이름(저장될 이름)
		double fileSize = 0; // 파일 사이즈
		// String fileExtension = null; // 파일 확장자
		int fileCnt = mf.size(); // 파일 개수

		for (int i = 0; i < mf.size(); i++) {

			file = mf.get(i);

			futsalImageDTO.setFiles(mf.get(i));

			originalFilename = mf.get(i).getOriginalFilename();
			fileName = System.currentTimeMillis() + "_" + originalFilename;
			fileSize = mf.get(i).getSize();
			// fileExtension = FilenameUtils.getExtension(originalFilename).toLowerCase();

			futsalImageDTO.setFutsalImagePath(fileName);

			// DAO 호출
			int resultParkImg = futsalDAO.insertImg(futsalImageDTO);
			if (resultParkImg == 0) {
				throw new RuntimeException();
			}

			file.transferTo(new File(imgPath + "/" + fileName));// 이미지 저장
		}
	}
}
