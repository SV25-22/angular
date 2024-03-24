package com.example.demo.picture;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PictureService {
	@Autowired
	private PictureRepository pictureRepository;
	public List<Picture> getAllPictures(){
		List<Picture> pictures = new ArrayList<>();
		pictureRepository.findAll().forEach(pictures::add);
		return pictures;
	}
	public void addPicture(Picture picture) {
		pictureRepository.save(picture);
	}
	public void updatePicture(String relPath,Picture picture) {
		if(pictureRepository.existsByRelPath(relPath)) {
			Picture foundPicture = pictureRepository.findByRelPath(relPath).get(0);
			foundPicture.updateValues(picture);
			pictureRepository.save(foundPicture);
		}else {
			return;
		}
	}
	public void deletePicture(String relPath) {
		pictureRepository.deleteByRelPath(relPath);
	}
}
