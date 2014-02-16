package no.pdigre.chess.engine.codegen;

import java.io.FileOutputStream;

import org.junit.Test;

public class XGen {
	
	@Test
	public void gen_GNodegenW() {
		try {
			FileOutputStream fos = new FileOutputStream("src/no/pdigre/chess/engine/base/GNodegenW.java");
			fos.write(new XNodegen().main("GNodegenW",true).getBytes());
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void gen_GNodegenB() {
		try {
			FileOutputStream fos = new FileOutputStream("src/no/pdigre/chess/engine/base/GNodegenB.java");
			fos.write(new XNodegen().main("GNodegenB",false).getBytes());
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
