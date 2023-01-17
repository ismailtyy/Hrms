package HRMS.hrms.entities.concretes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "job_titles")
public class JobTitle {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name = "id")
	private int id;
	@Column(name = "title")
	private String title;
	
	public JobTitle() {
		
	}

	public JobTitle(int id, String title) {
		super();
		this.id = id;
		this.title = title;
	}

}
