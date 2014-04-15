package com.mrprez.gencross.impl.pavillonNoir;

import com.mrprez.gencross.Version;
import com.mrprez.gencross.migration.MigrationPersonnage;
import com.mrprez.gencross.migration.Migrator;

public class MigrationFrom1_0 implements Migrator {

	@Override
	public MigrationPersonnage migrate(MigrationPersonnage migrationPersonnage) throws Exception {
		if(migrationPersonnage.getPhase().equals("création")){
			migrationPersonnage.setPassword("Création");
		}
		migrationPersonnage.getProperty("Compétences#Religion").getSubProperties().getDefaultProperty().setEditable(false);
		migrationPersonnage.getProperty("Compétences#Art").getSubProperties().getDefaultProperty().setEditable(false);
		migrationPersonnage.getProperty("Langue étrangère").getSubProperties().getDefaultProperty().setEditable(false);
		migrationPersonnage.getPluginDescriptor().setVersion(new Version(1,1));
		return migrationPersonnage;
	}

}
