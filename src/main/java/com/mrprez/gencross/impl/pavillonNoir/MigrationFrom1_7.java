package com.mrprez.gencross.impl.pavillonNoir;

import com.mrprez.gencross.Version;
import com.mrprez.gencross.migration.MigrationPersonnage;
import com.mrprez.gencross.migration.Migrator;

public class MigrationFrom1_7 implements Migrator {

	@Override
	public MigrationPersonnage migrate(MigrationPersonnage migrationPersonnage) throws Exception {
		migrationPersonnage.getFormulaManager().impactModificationFor("Attributs#Carrure", migrationPersonnage);
		migrationPersonnage.getFormulaManager().impactModificationFor("Attributs#Réflexe", migrationPersonnage);
		
		migrationPersonnage.getPluginDescriptor().setVersion(new Version(1, 8));
		
		return migrationPersonnage;
	}

}
