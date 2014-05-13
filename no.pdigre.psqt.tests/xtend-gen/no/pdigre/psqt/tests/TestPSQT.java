package no.pdigre.psqt.tests;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import no.pdigre.PSQTInjectorProvider;
import no.pdigre.PSQT_util;
import no.pdigre.pSQT.FDescription;
import no.pdigre.pSQT.PieceType;
import no.pdigre.pSQT.TDescription;
import no.pdigre.pSQT.Table;
import no.pdigre.psqt.tests.FileUtils;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.junit.Test;
import org.junit.runner.RunWith;

@InjectWith(PSQTInjectorProvider.class)
@RunWith(XtextRunner.class)
@SuppressWarnings("all")
public class TestPSQT {
  private int base = 0;
  
  private final String out_dir = "testdata/output";
  
  @Test
  public void parsePSQT() {
    this.createImages("testdata/Classic.psqt");
    this.createImages("testdata/StockFish.psqt");
  }
  
  public void createImages(final String path) {
    final File dir = new File(this.out_dir);
    boolean _exists = dir.exists();
    boolean _not = (!_exists);
    if (_not) {
      dir.mkdir();
    }
    final FDescription model = PSQT_util.readModel(path);
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
    String _name = model.getName();
    String _plus = ((this.out_dir + "/psqt_") + _name);
    String _plus_1 = (_plus + ".html");
    final File file = new File(_plus_1);
    String _createHTML = this.createHTML(model);
    FileUtils.string2file(_createHTML, file);
  }
  
  public boolean createImage(final TDescription table, final String name, final boolean isEnd) {
    try {
      boolean _xblockexpression = false;
      {
        final BufferedImage img = new BufferedImage(260, 260, BufferedImage.TYPE_INT_ARGB);
        final Graphics2D gc = img.createGraphics();
        gc.setColor(Color.YELLOW);
        gc.fillRect(0, 0, 260, 260);
        int min = 0;
        int max = 0;
        final int[] psqt = PSQT_util.getPSQT(table, isEnd);
        for (final int v : psqt) {
          {
            int _min = Math.min(min, v);
            min = _min;
            int _max = Math.max(max, v);
            max = _max;
          }
        }
        final int adj = ((max + min) / 2);
        int p = 0;
        for (final int v_1 : psqt) {
          int _plusPlus = p++;
          this.rect(gc, _plusPlus, v_1, adj);
        }
        gc.setColor(Color.BLACK);
        IntegerRange _upTo = new IntegerRange(0, 7);
        for (final Integer i : _upTo) {
          {
            String _string = Integer.toString(((i).intValue() + 1));
            gc.drawString(_string, (30 + ((i).intValue() * 30)), 255);
            String _substring = "HGFEDCBA".substring((i).intValue(), ((i).intValue() + 1));
            gc.drawString(_substring, 5, (20 + (30 * (i).intValue())));
          }
        }
        String _xifexpression = null;
        if (isEnd) {
          _xifexpression = "End";
        } else {
          _xifexpression = "Mid";
        }
        String _plus = ((((this.out_dir + "/") + name) + "_") + _xifexpression);
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
  
  public String createHTML(final FDescription model) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<html>");
    _builder.newLine();
    _builder.append("<head>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<title>PSQT: ");
    String _name = model.getName();
    _builder.append(_name, "\t");
    _builder.append("</title>");
    _builder.newLineIfNotEmpty();
    _builder.append("</head>");
    _builder.newLine();
    _builder.append("<body>");
    _builder.newLine();
    _builder.append("<h2>Piece Square Tables: ");
    String _name_1 = model.getName();
    _builder.append(_name_1, "");
    _builder.append("</h2>");
    _builder.newLineIfNotEmpty();
    _builder.append("<table>");
    _builder.newLine();
    {
      EList<Table> _tables = model.getTables();
      for(final Table table : _tables) {
        final PieceType n = ((TDescription) table).getName();
        _builder.newLineIfNotEmpty();
        _builder.append("<tr>");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("<td>MidGame ");
        _builder.append(n, "  ");
        _builder.append("<br><img src=\"");
        String _name_2 = model.getName();
        _builder.append(_name_2, "  ");
        _builder.append("_Mid");
        _builder.append(n, "  ");
        _builder.append(".png\"></td>");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("<td>EndGame ");
        _builder.append(n, "  ");
        _builder.append("<br><img src=\"");
        String _name_3 = model.getName();
        _builder.append(_name_3, "  ");
        _builder.append("_End");
        _builder.append(n, "  ");
        _builder.append(".png\"></td>");
        _builder.newLineIfNotEmpty();
        _builder.append("</tr>");
        _builder.newLine();
      }
    }
    _builder.append("<table>");
    _builder.newLine();
    _builder.append("</body>");
    _builder.newLine();
    _builder.append("</html>");
    _builder.newLine();
    return _builder.toString();
  }
  
  public void rect(final Graphics2D gc, final int p, final int i, final int adj) {
    final int c = (p % 8);
    final int r = (p / 8);
    final int str = ((int) (255 - ((((float) Math.abs((i - adj))) * 255) / this.base)));
    Color _xifexpression = null;
    if (((i - adj) > 0)) {
      _xifexpression = new Color(str, 255, str);
    } else {
      _xifexpression = new Color(255, str, str);
    }
    final Color col = _xifexpression;
    gc.setColor(col);
    final int x = ((c * 30) + 20);
    final int y = ((7 - r) * 30);
    gc.fillRect((1 + x), (1 + y), 28, 28);
    gc.setColor(Color.BLACK);
    gc.drawRect(x, y, 29, 29);
    String _string = Integer.toString(i);
    gc.drawString(_string, (2 + x), (15 + y));
  }
}
