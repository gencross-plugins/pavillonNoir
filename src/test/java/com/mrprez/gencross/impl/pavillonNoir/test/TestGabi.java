package com.mrprez.gencross.impl.pavillonNoir.test;

import java.io.File;
import java.io.FileInputStream;

import org.junit.Test;

import com.mrprez.gencross.Personnage;
import com.mrprez.gencross.disk.PersonnageFactory;
import com.mrprez.gencross.disk.PersonnageSaver;
import com.mrprez.gencross.history.HistoryPlayer;

public class TestGabi {
	
	@Test
	public void changeGabi() throws Exception{
		PersonnageFactory personnageFactory = new PersonnageFactory();
		Personnage historyPersonnage = personnageFactory.loadPersonnage(new FileInputStream("M:\\workspace\\pavillonNoir\\src\\test\\resources\\Gabi.xml"));
		HistoryPlayer historyPlayer = new HistoryPlayer(historyPersonnage.getHistory());
		
		Personnage personnage = personnageFactory.buildNewPersonnage("Pavillon Noir");
		
		historyPlayer.playHistory(personnage);
		
		PersonnageSaver.savePersonnageXml(personnage, new File("M:\\workspace\\pavillonNoir\\src\\test\\resources\\GabiRef.xml"));
		PersonnageSaver.savePersonnageGcr(personnage, new File("M:\\workspace\\pavillonNoir\\src\\test\\resources\\GabiRef.gcr"));
	}

}
