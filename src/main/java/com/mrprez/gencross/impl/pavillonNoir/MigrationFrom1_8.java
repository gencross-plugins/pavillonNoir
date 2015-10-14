package com.mrprez.gencross.impl.pavillonNoir;

import java.util.Iterator;

import com.mrprez.gencross.Version;
import com.mrprez.gencross.listener.AfterChangeValueListener;
import com.mrprez.gencross.listener.groovy.GroovyAfterChangeValueListener;
import com.mrprez.gencross.migration.MigrationPersonnage;
import com.mrprez.gencross.migration.Migrator;

public class MigrationFrom1_8 implements Migrator {

	@Override
	public MigrationPersonnage migrate(MigrationPersonnage migrationPersonnage) throws Exception {
		migrationPersonnage.getPluginDescriptor().setVersion(new Version(1, 9));
		Iterator<AfterChangeValueListener> it = migrationPersonnage.getAfterChangeValueListeners().iterator();
		while(it.hasNext()){
			if(it.next().getPattern().equals(".*#Apprentissage")){
				it.remove();
			}
		}
		
		GroovyAfterChangeValueListener newListener = new GroovyAfterChangeValueListener();
		newListener.setPattern(".*#Apprentissage");
		newListener.setScript("def competence = property.getOwner()\r\n"
				+ "def attributeName1 = competence.getSubProperty(\"Attribut 1\").getValue().getString()\r\n"
				+ "def attributeName2 = competence.getSubProperty(\"Attribut 2\").getValue().getString()\r\n"
				+ "def value1 = attributeName1 == \"3\" ? 3 : personnage.getProperty(\"Attributs\").getSubProperty(attributeName1).getValue().getInt()\r\n"
				+ "def value2 = attributeName2 == \"3\" ? 3 : personnage.getProperty(\"Attributs\").getSubProperty(attributeName2).getValue().getInt()\r\n"
				+ "def competenceValue = property.getValue().getInt() == 0 ? (value1 + value2) / 2 : value1 + value2 + property.getValue().getInt()\r\n"
				+ "competence.setValue(new IntValue(competenceValue))");
		migrationPersonnage.getAfterChangeValueListeners().add(newListener);
		
		return migrationPersonnage;
	}

}
