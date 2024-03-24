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
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "tables")
public class Job {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@ManyToOne
	private User user;
	LocalDateTime start;
	LocalDateTime end;
	String description;
	@ManyToOne
	Template template;
	String path;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	List<Picture> pictures;
}
