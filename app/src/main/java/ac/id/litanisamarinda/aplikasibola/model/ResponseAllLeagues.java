package ac.id.litanisamarinda.aplikasibola.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class ResponseAllLeagues{

	@SerializedName("countrys")
	private List<League> countrys;

	public void setCountrys(List<League> countrys){
		this.countrys = countrys;
	}

	public List<League> getAllLeagues(){
		return countrys;
	}

	@Override
 	public String toString(){
		return 
			"ResponseAllLeagues{" + 
			"countrys = '" + countrys + '\'' + 
			"}";
		}
}