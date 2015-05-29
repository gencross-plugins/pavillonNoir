package com.mrprez.gencross.impl.pavillonNoir;

import com.mrprez.gencross.Property;
import com.mrprez.gencross.Version;
import com.mrprez.gencross.history.LevelToReachHistoryFactory;
import com.mrprez.gencross.history.ProportionalHistoryFactory;
import com.mrprez.gencross.listener.custom.CustomAfterAddPropertyListener;
import com.mrprez.gencross.listener.custom.CustomAfterChangeValueListener;
import com.mrprez.gencross.listener.custom.CustomBeforeDeletePropertyListener;
import com.mrprez.gencross.listener.dummy.DummyAfterAddPropertyListener;
import com.mrprez.gencross.listener.dummy.DummyAfterChangeValueListener;
import com.mrprez.gencross.listener.dummy.DummyBeforeDeletePropertyListener;
import com.mrprez.gencross.migration.MigrationPersonnage;
import com.mrprez.gencross.migration.Migrator;
import com.mrprez.gencross.value.IntValue;
import com.mrprez.gencross.value.StringValue;

public class MigrationFrom1_8 implements Migrator {

	@Override
	public MigrationPersonnage migrate(MigrationPersonnage migrationPersonnage) throws Exception {
		migrationPersonnage.getPluginDescriptor().setVersion(new Version(1, 9));
		
		addDefaultCompetence(migrationPersonnage);
		
		
		addListener(migrationPersonnage);
		
		return migrationPersonnage;
	}
	
	
	private void addListener(MigrationPersonnage migrationPersonnage) throws SecurityException, NoSuchMethodException{
		migrationPersonnage.addAfterChangeValueListener(new DummyAfterChangeValueListener(new CustomAfterChangeValueListener(new PavillonNoir(), "changeCompetenceAttribut", "Compétences#[^#]*#Attribut [1-2]").getXml(), migrationPersonnage) );
		migrationPersonnage.addAfterAddPropertyListener(new DummyAfterAddPropertyListener(new CustomAfterAddPropertyListener(new PavillonNoir(), "addCompetence", "Compétences#.*").getXml(), migrationPersonnage));
		migrationPersonnage.getBeforeDeletePropertyListeners().clear();
		migrationPersonnage.addBeforeDeletePropertyListener(new DummyBeforeDeletePropertyListener(new CustomBeforeDeletePropertyListener(new PavillonNoir(), "removeCompetence", "Compétences#[^#]*#[^#]*").getXml(), migrationPersonnage));
		migrationPersonnage.addBeforeDeletePropertyListener(new DummyBeforeDeletePropertyListener(new CustomBeforeDeletePropertyListener(new PavillonNoir(), "removeCompetence", "Compétences#[^#]*").getXml(), migrationPersonnage));
	}
	
	
	
	
	private void addDefaultCompetence(MigrationPersonnage migrationPersonnage){
		Property defaultCompetence = new Property("", new IntValue(1), migrationPersonnage.getProperty("Compétences"), false);
		defaultCompetence.addSubPropertiesList(true, false);
		
		Property attribut1 = new Property("Attribut 1", new StringValue("Erudition"), defaultCompetence, true);
		attribut1.setOptions(new String[]{"Erudition", "Perception", "Pouvoir", "Carrure", "Dextérité", "Réflexe", "Social"});
		defaultCompetence.getSubProperties().add(attribut1);
		
		Property attribut2 = new Property("Attribut 2", new StringValue("Erudition"), defaultCompetence, true);
		attribut1.setOptions(new String[]{"Erudition", "Perception", "Pouvoir", "Carrure", "Dextérité", "Réflexe", "Social"});
		defaultCompetence.getSubProperties().add(attribut2);
		
		Property apprentissage = new Property("Apprentissage", new IntValue(0), defaultCompetence, true);
		apprentissage.setMin();
		if(migrationPersonnage.getPhase().equals("Création")){
			apprentissage.setMax(new IntValue(5));
			apprentissage.setHistoryFactory(new ProportionalHistoryFactory("Compétences"));
		}else{
			apprentissage.setHistoryFactory(new LevelToReachHistoryFactory("Expérience"));
		}
		defaultCompetence.getSubProperties().add(apprentissage);
		
		migrationPersonnage.getProperty("Compétences").getSubProperties().setDefaultProperty(defaultCompetence);
	}

}
