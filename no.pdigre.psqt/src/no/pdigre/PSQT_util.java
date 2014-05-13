package no.pdigre;

import no.pdigre.pSQT.FDescription;
import no.pdigre.pSQT.MRow;
import no.pdigre.pSQT.PSQT_Model;
import no.pdigre.pSQT.PieceType;
import no.pdigre.pSQT.Row;
import no.pdigre.pSQT.TDescription;
import no.pdigre.pSQT.Table;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

public class PSQT_util {
	
	public static FDescription readModel(String path){
		Resource resource = new ResourceSetImpl().getResource(URI.createURI(path), true);
		return (FDescription)resource.getContents().get(0);
	}
	
	public static int[] getPSQT(PSQT_Model model, PieceType pt,boolean isEnd){
		return getPSQT(getTable(pt, model),isEnd);
	}

	public static int[] getPSQT(TDescription table, boolean isEnd) {
		int p=64;
		int[] c=new int[64];
		for (Row r : table.getR()) {
			MRow row = isEnd?r.getEndrow():r.getMidrow();
			c[--p]=row.getC8();
			c[--p]=row.getC7();
			c[--p]=row.getC6();
			c[--p]=row.getC5();
			c[--p]=row.getC4();
			c[--p]=row.getC3();
			c[--p]=row.getC2();
			c[--p]=row.getC1();
		}
		return c;
	}

	public static TDescription getTable(PieceType pt, PSQT_Model model) {
		for (Table table : ((FDescription)model).getTables()) {
			TDescription t = (TDescription)table;
			if(t.getName()==pt)
				return t;
		}
		return null;
	}
}
