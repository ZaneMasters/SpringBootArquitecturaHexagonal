package com.api.domain.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

	@Entity
	public class Characters {
	   
		
		@Id
		private Long id;
		private String name;
		private String status;
		private String species;
		private String type;
		private String gender;
	
		@ElementCollection
		private List<String> episode;
		private String url;
		private String created;
	
		@ManyToOne(cascade = CascadeType.ALL)
		@JoinColumn(name = "location_id")
		private Location location;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getSpecies() {
			return species;
		}

		public void setSpecies(String species) {
			this.species = species;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public List<String> getEpisode() {
			return episode;
		}

		public void setEpisode(List<String> episode) {
			this.episode = episode;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getCreated() {
			return created;
		}

		public void setCreated(String created) {
			this.created = created;
		}

		public Location getLocation() {
			return location;
		}

		public void setLocation(Location location) {
			this.location = location;
		}


		
	}

