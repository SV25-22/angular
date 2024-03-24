package com.example.demo.picture;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
public class PictureController {
	@Autowired
	private PictureService pictureService;
	
	@GetMapping("/pictures")
	public List<Picture> getAllPictures(){
		return pictureService.getAllPictures();
	}
	
	@PostMapping("/pictures")
	public void addPicture(@RequestBody Picture picture) {
		pictureService.addPicture(picture);
	}
	
	@PutMapping("/pictures/{relPath}")
	public void updatePicture(@RequestBody Picture picture,@PathVariable("relPath") String relPath) {
		pictureService.updatePicture(relPath,picture);
	}
	@DeleteMapping("/pictures/{relPath}")
	public void deletePicture(@PathVariable("relPath") String relPath) {
		pictureService.deletePicture(relPath);
	}
}
