package data.dto.prodaja_vozila;

import java.io.Serializable;

import data.dto.prodaja_vozila.KlijentDTO;

@SuppressWarnings("serial")
public class DistributerVozilaDTO implements Serializable {

	private String rejting;
	private KlijentDTO klijent;

	public String getRejting() {
		return rejting;
	}

	public void setRejting(String rejting) {
		this.rejting = rejting;
	}

	public KlijentDTO getKlijent() {
		return klijent;
	}

	public void setKlijent(KlijentDTO klijent) {
		this.klijent = klijent;
	}

	public DistributerVozilaDTO(KlijentDTO klijent, String rejting) {
		super();
		this.rejting = rejting;
		this.klijent = klijent;
	}

	public DistributerVozilaDTO() {
		super();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DistributerVozilaDTO other = (DistributerVozilaDTO) obj;
		if (klijent == null) {
			if (other.klijent != null)
				return false;
		} else if (!klijent.equals(other.klijent))
			return false;
		if (rejting == null) {
			if (other.rejting != null)
				return false;
		} else if (!rejting.equals(other.rejting))
			return false;
		return true;
	}

}
