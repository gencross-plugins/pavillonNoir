package com.mrprez.gencross.impl.pavillonNoir;

import com.mrprez.gencross.PropertiesList;
import com.mrprez.gencross.Property;
import com.mrprez.gencross.Version;
import com.mrprez.gencross.value.StringValue;
import com.mrprez.gencross.migration.MigrationPersonnage;
import com.mrprez.gencross.migration.Migrator;


public class MigrationFrom1_9_1 implements Migrator {

	@Override
	public MigrationPersonnage migrate(MigrationPersonnage migrationPersonnage) throws Exception {
		migrationPersonnage.getPluginDescriptor().setVersion(new Version(1, 9, 2));
		
		Property defaultCompetence = migrationPersonnage.getProperty("Compétences").getSubProperties().getDefaultProperty();
		
		Property attribut1 = new Property("Attribut 1", new StringValue("3"), defaultCompetence, true);
		attribut1.setOptions(new String[]{"Erudition", "Perception", "Pouvoir", "Carrure", "Dextérité", "Réflexe", "Social", "3"});
		defaultCompetence.getSubProperties().add(attribut1);
		
		Property attribut2 = new Property("Attribut 2", new StringValue("3"), defaultCompetence, true);
		attribut2.setOptions(new String[]{"Erudition", "Perception", "Pouvoir", "Carrure", "Dextérité", "Réflexe", "Social", "3"});
		defaultCompetence.getSubProperties().add(attribut2);
		
		return migrationPersonnage;
	}
	
	
}
