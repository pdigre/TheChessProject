package no.pdigre.psqt.tests;

import java.io.File;
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
    this.createCodeFile("testdata/Classic.psqt");
    this.createCodeFile("testdata/StockFish.psqt");
  }
  
  public void createCodeFile(final String path) {
    final File dir = new File(this.out_dir);
    boolean _exists = dir.exists();
    boolean _not = (!_exists);
    if (_not) {
      dir.mkdir();
    }
    final FDescription model = PSQT_util.readModel(path);
    int _base = model.getBase();
    this.base = _base;
    String _name = model.getName();
    String _plus = ((this.out_dir + "/") + _name);
    String _plus_1 = (_plus + ".txt");
    final File file = new File(_plus_1);
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<Table> _tables = model.getTables();
      for(final Table table : _tables) {
        _builder.append("{ // ");
        PieceType _name_1 = ((TDescription) table).getName();
        _builder.append(_name_1, "");
        _builder.newLineIfNotEmpty();
        String _writeTable = this.writeTable(((TDescription) table));
        _builder.append(_writeTable, "");
        _builder.newLineIfNotEmpty();
        _builder.append("},");
        _builder.newLine();
      }
    }
    final String code = _builder.toString();
    FileUtils.string2file(code, file);
  }
  
  public String writeTable(final TDescription table) {
    final int[] m = PSQT_util.getPSQT(table, false);
    final int[] e = PSQT_util.getPSQT(table, true);
    final StringBuilder sb = new StringBuilder();
    IntegerRange _upTo = new IntegerRange(0, 7);
    for (final Integer r : _upTo) {
      {
        IntegerRange _upTo_1 = new IntegerRange(0, 7);
        for (final Integer c : _upTo_1) {
          {
            final int p = (((r).intValue() * 8) + (c).intValue());
            if (((c).intValue() != 0)) {
              sb.append(",");
            }
            int _get = m[p];
            String _string = Integer.toString(_get);
            String _format = this.format(_string);
            String _plus = (" S(" + _format);
            String _plus_1 = (_plus + ",");
            int _get_1 = e[p];
            String _string_1 = Integer.toString(_get_1);
            String _format_1 = this.format(_string_1);
            String _plus_2 = (_plus_1 + _format_1);
            String _plus_3 = (_plus_2 + ")");
            sb.append(_plus_3);
          }
        }
        if (((r).intValue() != 7)) {
          sb.append(",");
        }
        sb.append("\n");
      }
    }
    return sb.toString();
  }
  
  public String format(final String txt) {
    int _length = txt.length();
    String _substring = "    ".substring(_length);
    return (_substring + txt);
  }
}
