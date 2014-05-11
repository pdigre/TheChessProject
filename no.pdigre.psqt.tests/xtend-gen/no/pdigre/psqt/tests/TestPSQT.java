package no.pdigre.psqt.tests;

import com.google.inject.Inject;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import javax.imageio.ImageIO;
import no.pdigre.PSQTInjectorProvider;
import no.pdigre.pSQT.FDescription;
import no.pdigre.pSQT.MRow;
import no.pdigre.pSQT.PSQT_Model;
import no.pdigre.pSQT.PieceType;
import no.pdigre.pSQT.Row;
import no.pdigre.pSQT.TDescription;
import no.pdigre.pSQT.Table;
import no.pdigre.psqt.tests.FileUtils;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.junit.Test;
import org.junit.runner.RunWith;

@InjectWith(PSQTInjectorProvider.class)
@RunWith(XtextRunner.class)
@SuppressWarnings("all")
public class TestPSQT {
  private int base = 0;
  
  @Inject
  private ParseHelper<PSQT_Model> parser;
  
  @Test
  public void parsePSQT() {
    this.createImages("testdata/Classic.psqt");
    this.createImages("testdata/StockFish.psqt");
  }
  
  public void createImages(final String path) {
    try {
      FileInputStream _fileInputStream = new FileInputStream(path);
      String _stream2string = FileUtils.stream2string(_fileInputStream);
      PSQT_Model _parse = this.parser.parse(_stream2string);
      final FDescription model = ((FDescription) _parse);
      int _base = model.getBase();
      this.base = _base;
      EList<Table> _tables = model.getTables();
      for (final Table table : _tables) {
        {
          String _name = model.getName();
          this.createImage(((TDescription) table), _name, false);
          String _name_1 = model.getName();
          this.createImage(((TDescription) table), _name_1, true);
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public boolean createImage(final TDescription table, final String name, final boolean isEnd) {
    try {
      boolean _xblockexpression = false;
      {
        final BufferedImage img = new BufferedImage(260, 260, BufferedImage.TYPE_INT_ARGB);
        final Graphics2D gc = img.createGraphics();
        int p = 0;
        gc.setColor(Color.YELLOW);
        gc.fillRect(0, 0, 260, 260);
        int min = 0;
        int max = 0;
        EList<Row> _r = table.getR();
        for (final Row r : _r) {
          {
            MRow _xifexpression = null;
            if (isEnd) {
              _xifexpression = r.getEndrow();
            } else {
              _xifexpression = r.getMidrow();
            }
            final MRow m = ((MRow) _xifexpression);
            int _c1 = m.getC1();
            int _min = Math.min(min, _c1);
            min = _min;
            int _c1_1 = m.getC1();
            int _max = Math.max(max, _c1_1);
            max = _max;
            int _c2 = m.getC2();
            int _min_1 = Math.min(min, _c2);
            min = _min_1;
            int _c2_1 = m.getC2();
            int _max_1 = Math.max(max, _c2_1);
            max = _max_1;
            int _c3 = m.getC3();
            int _min_2 = Math.min(min, _c3);
            min = _min_2;
            int _c3_1 = m.getC3();
            int _max_2 = Math.max(max, _c3_1);
            max = _max_2;
            int _c4 = m.getC4();
            int _min_3 = Math.min(min, _c4);
            min = _min_3;
            int _c4_1 = m.getC4();
            int _max_3 = Math.max(max, _c4_1);
            max = _max_3;
            int _c5 = m.getC5();
            int _min_4 = Math.min(min, _c5);
            min = _min_4;
            int _c5_1 = m.getC5();
            int _max_4 = Math.max(max, _c5_1);
            max = _max_4;
            int _c6 = m.getC6();
            int _min_5 = Math.min(min, _c6);
            min = _min_5;
            int _c6_1 = m.getC6();
            int _max_5 = Math.max(max, _c6_1);
            max = _max_5;
            int _c7 = m.getC7();
            int _min_6 = Math.min(min, _c7);
            min = _min_6;
            int _c7_1 = m.getC7();
            int _max_6 = Math.max(max, _c7_1);
            max = _max_6;
            int _c8 = m.getC8();
            int _min_7 = Math.min(min, _c8);
            min = _min_7;
            int _c8_1 = m.getC8();
            int _max_7 = Math.max(max, _c8_1);
            max = _max_7;
          }
        }
        final int adj = ((max + min) / 2);
        EList<Row> _r_1 = table.getR();
        for (final Row r_1 : _r_1) {
          {
            MRow _xifexpression = null;
            if (isEnd) {
              _xifexpression = r_1.getEndrow();
            } else {
              _xifexpression = r_1.getMidrow();
            }
            final MRow m = ((MRow) _xifexpression);
            int _plusPlus = p++;
            int _c1 = m.getC1();
            this.rect(gc, _plusPlus, _c1, adj);
            int _plusPlus_1 = p++;
            int _c2 = m.getC2();
            this.rect(gc, _plusPlus_1, _c2, adj);
            int _plusPlus_2 = p++;
            int _c3 = m.getC3();
            this.rect(gc, _plusPlus_2, _c3, adj);
            int _plusPlus_3 = p++;
            int _c4 = m.getC4();
            this.rect(gc, _plusPlus_3, _c4, adj);
            int _plusPlus_4 = p++;
            int _c5 = m.getC5();
            this.rect(gc, _plusPlus_4, _c5, adj);
            int _plusPlus_5 = p++;
            int _c6 = m.getC6();
            this.rect(gc, _plusPlus_5, _c6, adj);
            int _plusPlus_6 = p++;
            int _c7 = m.getC7();
            this.rect(gc, _plusPlus_6, _c7, adj);
            int _plusPlus_7 = p++;
            int _c8 = m.getC8();
            this.rect(gc, _plusPlus_7, _c8, adj);
          }
        }
        gc.setColor(Color.BLACK);
        IntegerRange _upTo = new IntegerRange(0, 7);
        for (final Integer i : _upTo) {
          {
            String _string = Integer.toString(((i).intValue() + 1));
            gc.drawString(_string, (30 + ((i).intValue() * 30)), 255);
            String _substring = "ABCDEFGH".substring((i).intValue(), ((i).intValue() + 1));
            gc.drawString(_substring, 5, (20 + (30 * (i).intValue())));
          }
        }
        final File dir = new File("testdata/output");
        boolean _exists = dir.exists();
        boolean _not = (!_exists);
        if (_not) {
          dir.mkdir();
        }
        String _xifexpression = null;
        if (isEnd) {
          _xifexpression = "Mid";
        } else {
          _xifexpression = "End";
        }
        String _plus = ((("testdata/output/" + name) + "_") + _xifexpression);
        PieceType _name = table.getName();
        String _plus_1 = (_plus + _name);
        String _plus_2 = (_plus_1 + ".png");
        File _file = new File(_plus_2);
        _xblockexpression = ImageIO.write(img, "PNG", _file);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void rect(final Graphics2D gc, final int p, final int i, final int adj) {
    final int c = (p % 8);
    final int r = (p / 8);
    final int str = ((int) (255 - ((((float) Math.abs((i - adj))) * 255) / this.base)));
    if (((str > 255) || (str < 0))) {
      InputOutput.<String>println("hi");
    }
    Color _xifexpression = null;
    if (((i - adj) > 0)) {
      _xifexpression = new Color(str, 255, str);
    } else {
      _xifexpression = new Color(255, str, str);
    }
    final Color col = _xifexpression;
    gc.setColor(col);
    final int x = ((c * 30) + 20);
    final int y = (r * 30);
    gc.fillRect((1 + x), (1 + y), 27, 27);
    Color _xifexpression_1 = null;
    if ((((c + r) % 2) == 1)) {
      _xifexpression_1 = Color.WHITE;
    } else {
      _xifexpression_1 = Color.BLACK;
    }
    gc.setColor(_xifexpression_1);
    gc.drawRect(x, y, 29, 29);
    gc.setColor(Color.BLACK);
    String _string = Integer.toString(i);
    gc.drawString(_string, (2 + x), (15 + y));
  }
}
