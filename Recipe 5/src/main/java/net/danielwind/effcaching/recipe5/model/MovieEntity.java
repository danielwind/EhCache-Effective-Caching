package net.danielwind.effcaching.recipe5.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "movies")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY, region = "entityCache")
public class MovieEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private String title;
	private String publisher;
	private Date releaseDate;

	
	/**
	 * Default Constructor (required)
	 */
	public MovieEntity() {
		
	}
	
	/**
	 * Overloaded Constructor
	 */
	public MovieEntity(long id, String title, String publisher, Date releaseDate) {
		
		this.id = id;
		this.title = title;
		this.publisher = publisher;
		this.releaseDate = releaseDate;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "title", nullable = false, length = 50)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "publisher", nullable = false, length = 30)
	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "release_date", nullable = false, length = 7)
	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("[");
		sb.append("Title: " + this.title);
		sb.append(",");
		sb.append("Publisher: " + this.publisher);
		sb.append(",");
		sb.append("Release Date: " + this.releaseDate.toString());
		sb.append("]");
		
		return sb.toString();
	}
}