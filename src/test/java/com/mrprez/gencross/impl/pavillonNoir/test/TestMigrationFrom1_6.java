package com.mrprez.gencross.impl.pavillonNoir.test;

import com.mrprez.gencross.test.MigratorTest;

import com.mrprez.gencross.Personnage;
import com.mrprez.gencross.disk.PersonnageFactory;
import com.mrprez.gencross.disk.PersonnageSaver;


public class TestMigrationFrom1_6 extends MigratorTest {

	public TestMigrationFrom1_6() {
		Personnage personnage = personnageFactory.loadPersonnage(ClassLoader.getSystemResourceAsStream(fileName));
		System.out.println("personnage loaded");
		PersonnageSaver.savePersonnageXml(personnage, getResultFile());
		System.out.println("personnage saved in "+getResultFile().getAbsolutePath());
		Assert.assertTrue(getRefFile().getAbsolutePath()+" does not exist", getRefFile().exists());
		super("Esclave_marron.xml");
	}

}
