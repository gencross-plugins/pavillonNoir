package com.mrprez.gencross.impl.pavillonNoir;

import com.mrprez.gencross.Personnage;
import com.mrprez.gencross.Property;
import com.mrprez.gencross.value.IntValue;
import com.mrprez.gencross.value.Value;

public class PavillonNoir extends Personnage {
	
	
	@Override
	public void calculate() {
		super.calculate();
	}
	
	
	public void changeApprentissage(Property apprentissage, Value oldValue){
		Property competence = (Property) apprentissage.getOwner();
		calculateCompetence(competence);
	}
	
	public void changeAttribut(Property attribut, Value oldValue){
		for( Property property : getProperty("Compétences").getSubProperties() ){
			if(property.getSubProperty("Apprentissage")!=null){
				calculateCompetence(property);
			}else{
				for(Property subProperty : property.getSubProperties()){
					calculateCompetence(subProperty);
				}
				calculateCompetence(property.getSubProperties().getDefaultProperty());
			}
		}
	}
	
	
	private void calculateCompetence(Property competence){
		Property apprentissage = competence.getSubProperty("Apprentissage");
		String attributeName1 = competence.getSubProperty("Attribut 1").getValue().getString();
		String attributeName2 = competence.getSubProperty("Attribut 2").getValue().getString();
		int value1;
		if(attributeName1.equals("3")){
			value1 = 3;
		}else{
			value1 = getProperty("Attributs").getSubProperty(attributeName1).getValue().getInt();
		}
		int value2;
		if(attributeName2.equals("3")){
			value2 = 3;
		}else{
			value2 = getProperty("Attributs").getSubProperty(attributeName2).getValue().getInt();
		}
		if(apprentissage.getValue().getInt()==0){
			int base = (value1 + value2) / 2;
			competence.setValue(new IntValue(base));
		}else{
			int base = value1 + value2;
			competence.setValue(new IntValue(base+apprentissage.getValue().getInt()));
		}
	}

	

	
	
	

}
