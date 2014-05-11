package com.mrprez.gencross.impl.pavillonNoir;

import com.mrprez.gencross.Version;
import com.mrprez.gencross.migration.MigrationPersonnage;
import com.mrprez.gencross.migration.Migrator;

public class MigrationFrom1_2 implements Migrator {

	@Override
	public MigrationPersonnage migrate(MigrationPersonnage migrationPersonnage) throws Exception {
		migrationPersonnage.getProperty("Compétences").getSubProperties().setFixe(true);
		migrationPersonnage.getPluginDescriptor().setVersion(new Version(1,3));
		return migrationPersonnage;
	}

}
