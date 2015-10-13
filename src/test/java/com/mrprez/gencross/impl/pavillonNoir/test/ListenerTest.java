package com.mrprez.gencross.impl.pavillonNoir.test;

import org.junit.Assert;
import org.junit.Test;

import com.mrprez.gencross.Personnage;
import com.mrprez.gencross.Property;
import com.mrprez.gencross.disk.PersonnageFactory;
import com.mrprez.gencross.value.IntValue;

public class ListenerTest {
	
	@Test
	public void testChangeApprentissage() throws Exception{
		PersonnageFactory personnageFactory = new PersonnageFactory();
		Personnage personnage = personnageFactory.buildNewPersonnage("Pavillon Noir");
		Property apprentissage = personnage.getProperty("Compétences#Balistique#Apprentissage");
		personnage.setNewValue(apprentissage, new IntValue(2));
		Assert.assertEquals(4, personnage.getProperty("Compétences#Balistique").getValue().getInt());
	}

}
