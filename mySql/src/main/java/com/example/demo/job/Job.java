package com.example.demo.job;
import com.example.demo.picture.Picture;
import com.example.demo.template.Template;
import com.example.demo.user.User;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;

@Entity
public class Job {
	@Id
	private String name;
	@ManyToOne
	private User user;
	LocalDateTime start;
	LocalDateTime end;
	String description;
	@ManyToOne
	Template template;
	String path;
    @ElementCollection
    @CollectionTable(name = "job_pictures", joinColumns = @JoinColumn(name = "job_name"))

	List<Picture> pictures;
}
