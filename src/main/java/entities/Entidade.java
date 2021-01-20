package entities;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@MappedSuperclass
public abstract class Entidade implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(nullable = false, name = "created_at")
	private Calendar createDateTime;

	@Column(nullable = false, name = "updated_at")
	private Calendar updateDateTime;

	public Long getId() {
		return id;
	}

	public Calendar getCreateDateTime() {
		return this.createDateTime;
	}

	@PrePersist
	private void setCreateDateTime() {
		this.createDateTime = Calendar.getInstance();
	}

	public Calendar getUpdateDateTime() {
		return this.updateDateTime;
	}

	@PreUpdate
	private void setUpdateDateTime() {
		this.updateDateTime = Calendar.getInstance();
	}

	@Override
	public boolean equals(Object obj) {
		try {
			Entidade entidade = (Entidade) obj;

			return entidade.getId() == this.id;
		} catch (ClassCastException ex) {
			return false;
		}
	}
}
