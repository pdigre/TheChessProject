package no.pdigre.psqt.tests

import com.google.inject.Inject
import java.awt.Color
import java.awt.Graphics2D
import java.awt.image.BufferedImage
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileInputStream
import java.io.InputStream
import javax.imageio.ImageIO
import no.pdigre.PSQTInjectorProvider
import no.pdigre.pSQT.FDescription
import no.pdigre.pSQT.MRow
import no.pdigre.pSQT.PSQT_Model
import no.pdigre.pSQT.TDescription
import no.pdigre.pSQT.Table
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.junit.Test
import org.junit.runner.RunWith
import org.w3c.dom.Entity

@InjectWith(PSQTInjectorProvider)
@RunWith(XtextRunner)
class TestPSQT {
	
	var base=0
	
	@Inject
	ParseHelper<PSQT_Model> parser	
	
	@Test 
	def void parsePSQT() {
	  createImages("testdata/Classic.psqt")
	  createImages("testdata/StockFish.psqt")
	}
	
	def createImages(String path) {
 	  val model = parser.parse(FileUtils.stream2string(new FileInputStream(path))) as FDescription
	  base=model.base
	  for(table:model.tables){
	  	createImage(table as TDescription,model.name,false)
	  	createImage(table as TDescription,model.name,true)
	  }
	}
	
	def createImage(TDescription table,String name,boolean isEnd) {
	  	val img = new BufferedImage(260, 260, BufferedImage.TYPE_INT_ARGB);
		val gc = img.createGraphics
		var p=0
		gc.setColor(Color.YELLOW)
		gc.fillRect(0,0,260,260)
		for(r:table.r){
			val m = r.midrow as MRow
			gc.rect(p++,m.c1)
			gc.rect(p++,m.c2)
			gc.rect(p++,m.c3)
			gc.rect(p++,m.c4)
			gc.rect(p++,m.c5)
			gc.rect(p++,m.c6)
			gc.rect(p++,m.c7)
			gc.rect(p++,m.c8)
		}
		gc.setColor(Color.BLACK)
		for(i:0..7){
			gc.drawString(Integer.toString(i+1),30+i*30,255)
			gc.drawString("ABCDEFGH".substring(i,i+1),5,20+30*i)
		}
		ImageIO::write(img, "PNG", new File("testdata/"+name+"_"+(if(isEnd)"Mid" else "End")+table.name+".png"))
	}
	
	def rect(Graphics2D gc,int p,int i) {
		val c=p%8
		val r=p/8
		val str=(255-(Math::abs(i) as float)*255/base) as int
		val col=if(i>0)new Color(str,255,str) else new Color(255,str,str)
		gc.setColor(col)
		val x=c*30+20
		val y=r*30
		gc.fillRect(1+x,1+y,27,27)
		gc.setColor(if((c+r)%2==1) Color.WHITE else Color.BLACK)
		gc.drawRect(x,y,29,29)
		gc.setColor(Color.BLACK)
		gc.drawString(Integer.toString(i),2+x,15+y)
	}
	
}