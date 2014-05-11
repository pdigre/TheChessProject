package no.pdigre.psqt.tests

import com.google.inject.Inject
import java.awt.Color
import java.awt.Graphics2D
import java.awt.image.BufferedImage
import java.io.File
import java.io.FileInputStream
import javax.imageio.ImageIO
import no.pdigre.PSQTInjectorProvider
import no.pdigre.pSQT.FDescription
import no.pdigre.pSQT.MRow
import no.pdigre.pSQT.PSQT_Model
import no.pdigre.pSQT.TDescription
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.junit.Test
import org.junit.runner.RunWith

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
		var min=0;
		var max=0;
		for(r:table.r){
			val m = (if(isEnd)r.endrow else r.midrow) as MRow 
			min=Math::min(min,m.c1)
			max=Math::max(max,m.c1)
			min=Math::min(min,m.c2)
			max=Math::max(max,m.c2)
			min=Math::min(min,m.c3)
			max=Math::max(max,m.c3)
			min=Math::min(min,m.c4)
			max=Math::max(max,m.c4)
			min=Math::min(min,m.c5)
			max=Math::max(max,m.c5)
			min=Math::min(min,m.c6)
			max=Math::max(max,m.c6)
			min=Math::min(min,m.c7)
			max=Math::max(max,m.c7)
			min=Math::min(min,m.c8)
			max=Math::max(max,m.c8)
		}
		val adj=(max+min)/2
		for(r:table.r){
			val m = (if(isEnd)r.endrow else r.midrow) as MRow 
			gc.rect(p++,m.c1,adj)
			gc.rect(p++,m.c2,adj)
			gc.rect(p++,m.c3,adj)
			gc.rect(p++,m.c4,adj)
			gc.rect(p++,m.c5,adj)
			gc.rect(p++,m.c6,adj)
			gc.rect(p++,m.c7,adj)
			gc.rect(p++,m.c8,adj)
		}
		gc.setColor(Color.BLACK)
		for(i:0..7){
			gc.drawString(Integer.toString(i+1),30+i*30,255)
			gc.drawString("ABCDEFGH".substring(i,i+1),5,20+30*i)
		}
		val dir = new File("testdata/output")
		if(!dir.exists)
			dir.mkdir
		ImageIO::write(img, "PNG", new File("testdata/output/"+name+"_"+(if(isEnd)"Mid" else "End")+table.name+".png"))
	}
	
	def rect(Graphics2D gc,int p,int i,int adj) {
		val c=p%8
		val r=p/8
		val str=(255-(Math::abs(i-adj) as float)*255/base) as int
		if(str>255 || str<0)
		println("hi")
		val col=if(i-adj>0)new Color(str,255,str) else new Color(255,str,str)
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