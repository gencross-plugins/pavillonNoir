package com.mrprez.gencross.impl.pavillonNoir;

import com.mrprez.gencross.Property;
import com.mrprez.gencross.Version;
import com.mrprez.gencross.migration.MigrationPersonnage;
import com.mrprez.gencross.migration.Migrator;

public class MigrationFrom1_6 implements Migrator {

	@Override
	public MigrationPersonnage migrate(MigrationPersonnage migrationPersonnage) throws Exception {
		Property competences = migrationPersonnage.getProperty("Compétences");
		
		for(Property competence : competences.getSubProperties()){
			competence.setEditable(false);
			if(competence.getSubProperty("Apprentissage")==null){
				for(Property sousCompetence : competence.getSubProperties()){
					sousCompetence.setEditable(false);
				}
				if(competence.getSubProperties().getOptions() != null){
					for(Property competenceOption : competence.getSubProperties().getOptions().values()){
						competenceOption.setEditable(false);
					}
				}
				if(competence.getSubProperties().getDefaultProperty() != null){
					competence.getSubProperties().getDefaultProperty().setEditable(false);
				}
			}
		}
		
		migrationPersonnage.getPluginDescriptor().setVersion(new Version(1,7));
		
		return migrationPersonnage;
	}

}
