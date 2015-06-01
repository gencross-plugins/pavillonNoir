package com.mrprez.gencross.impl.pavillonNoir;

import com.mrprez.gencross.PropertiesList;
import com.mrprez.gencross.Property;
import com.mrprez.gencross.Version;
import com.mrprez.gencross.migration.MigrationPersonnage;
import com.mrprez.gencross.migration.Migrator;


public class MigrationFrom1_9 implements Migrator {

	@Override
	public MigrationPersonnage migrate(MigrationPersonnage migrationPersonnage) throws Exception {
		migrationPersonnage.getPluginDescriptor().setVersion(new Version(1, 9, 1));
		PropertiesList subProperties = migrationPersonnage.getProperty("Compétences").getSubProperties();
		subProperties.setFixe(false);
		
		Property defaultProperty = subProperties.getDefaultProperty();
		subProperties.setOpen(true);
		subProperties.setDefaultProperty(defaultProperty);
		
		return migrationPersonnage;
	}
	
	
}
