package com.mrprez.gencross.impl.pavillonNoir;

import com.mrprez.gencross.Version;
import com.mrprez.gencross.formula.Formula;
import com.mrprez.gencross.migration.MigrationPersonnage;
import com.mrprez.gencross.migration.Migrator;

public class MigrationFrom1_7 implements Migrator {

	@Override
	public MigrationPersonnage migrate(MigrationPersonnage migrationPersonnage) throws Exception {
		migrationPersonnage.getFormulaManager().removeFormula("Esquive");
		migrationPersonnage.getFormulaManager().removeFormula("Vie");
		migrationPersonnage.getFormulaManager().addFormula(new Formula("Esquive=#Attributs#Réflexe# * 4 + 4"));
		migrationPersonnage.getFormulaManager().addFormula(new Formula("Vie=#Attributs#Carrure# * 2 + 4"));
		migrationPersonnage.getFormulaManager().impactModificationFor("Attributs#Carrure", migrationPersonnage);
		migrationPersonnage.getFormulaManager().impactModificationFor("Attributs#Réflexe", migrationPersonnage);
		
		migrationPersonnage.getPluginDescriptor().setVersion(new Version(1, 8));
		
		return migrationPersonnage;
	}

}
