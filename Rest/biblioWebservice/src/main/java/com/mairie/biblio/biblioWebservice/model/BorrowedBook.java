package com.mairie.biblio.biblioWebservice.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "borrowed_book")
public class BorrowedBook {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name = "borrowedBook_id")
	private int id;
	
	private Boolean availableExtension;
	
	@Temporal(TemporalType.DATE)
	private Date dateBorrowing;
	
	@OneToOne
	@JoinColumn(name="book_id")
	private Book book;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	public BorrowedBook (Boolean availableExtension,Date dateBorrowing,Book book,User user) {
		super();
		this.availableExtension = availableExtension;
		this.dateBorrowing = dateBorrowing;
		this.book = book;
		this.user = user;
	}

}
