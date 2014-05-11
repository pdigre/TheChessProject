/**
 */
package no.pdigre.pSQT;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see no.pdigre.pSQT.PSQTFactory
 * @model kind="package"
 * @generated
 */
public interface PSQTPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "pSQT";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.pdigre.no/PSQT";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "pSQT";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  PSQTPackage eINSTANCE = no.pdigre.pSQT.impl.PSQTPackageImpl.init();

  /**
   * The meta object id for the '{@link no.pdigre.pSQT.impl.PSQT_ModelImpl <em>PSQT Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see no.pdigre.pSQT.impl.PSQT_ModelImpl
   * @see no.pdigre.pSQT.impl.PSQTPackageImpl#getPSQT_Model()
   * @generated
   */
  int PSQT_MODEL = 0;

  /**
   * The number of structural features of the '<em>PSQT Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PSQT_MODEL_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link no.pdigre.pSQT.impl.FDescriptionImpl <em>FDescription</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see no.pdigre.pSQT.impl.FDescriptionImpl
   * @see no.pdigre.pSQT.impl.PSQTPackageImpl#getFDescription()
   * @generated
   */
  int FDESCRIPTION = 1;

  /**
   * The feature id for the '<em><b>Tables</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FDESCRIPTION__TABLES = PSQT_MODEL_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FDESCRIPTION__NAME = PSQT_MODEL_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Base</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FDESCRIPTION__BASE = PSQT_MODEL_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Mgl</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FDESCRIPTION__MGL = PSQT_MODEL_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Egl</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FDESCRIPTION__EGL = PSQT_MODEL_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>FDescription</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FDESCRIPTION_FEATURE_COUNT = PSQT_MODEL_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link no.pdigre.pSQT.impl.TableImpl <em>Table</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see no.pdigre.pSQT.impl.TableImpl
   * @see no.pdigre.pSQT.impl.PSQTPackageImpl#getTable()
   * @generated
   */
  int TABLE = 2;

  /**
   * The number of structural features of the '<em>Table</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TABLE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link no.pdigre.pSQT.impl.TDescriptionImpl <em>TDescription</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see no.pdigre.pSQT.impl.TDescriptionImpl
   * @see no.pdigre.pSQT.impl.PSQTPackageImpl#getTDescription()
   * @generated
   */
  int TDESCRIPTION = 3;

  /**
   * The feature id for the '<em><b>R</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TDESCRIPTION__R = TABLE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TDESCRIPTION__NAME = TABLE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Mg</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TDESCRIPTION__MG = TABLE_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Eg</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TDESCRIPTION__EG = TABLE_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>TDescription</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TDESCRIPTION_FEATURE_COUNT = TABLE_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link no.pdigre.pSQT.impl.RowImpl <em>Row</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see no.pdigre.pSQT.impl.RowImpl
   * @see no.pdigre.pSQT.impl.PSQTPackageImpl#getRow()
   * @generated
   */
  int ROW = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROW__NAME = 0;

  /**
   * The feature id for the '<em><b>Midrow</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROW__MIDROW = 1;

  /**
   * The feature id for the '<em><b>Endrow</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROW__ENDROW = 2;

  /**
   * The number of structural features of the '<em>Row</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROW_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link no.pdigre.pSQT.impl.MRowImpl <em>MRow</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see no.pdigre.pSQT.impl.MRowImpl
   * @see no.pdigre.pSQT.impl.PSQTPackageImpl#getMRow()
   * @generated
   */
  int MROW = 5;

  /**
   * The feature id for the '<em><b>C1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MROW__C1 = 0;

  /**
   * The feature id for the '<em><b>C2</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MROW__C2 = 1;

  /**
   * The feature id for the '<em><b>C3</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MROW__C3 = 2;

  /**
   * The feature id for the '<em><b>C4</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MROW__C4 = 3;

  /**
   * The feature id for the '<em><b>C5</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MROW__C5 = 4;

  /**
   * The feature id for the '<em><b>C6</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MROW__C6 = 5;

  /**
   * The feature id for the '<em><b>C7</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MROW__C7 = 6;

  /**
   * The feature id for the '<em><b>C8</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MROW__C8 = 7;

  /**
   * The number of structural features of the '<em>MRow</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MROW_FEATURE_COUNT = 8;

  /**
   * The meta object id for the '{@link no.pdigre.pSQT.impl.ERowImpl <em>ERow</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see no.pdigre.pSQT.impl.ERowImpl
   * @see no.pdigre.pSQT.impl.PSQTPackageImpl#getERow()
   * @generated
   */
  int EROW = 6;

  /**
   * The feature id for the '<em><b>C1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EROW__C1 = 0;

  /**
   * The feature id for the '<em><b>C2</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EROW__C2 = 1;

  /**
   * The feature id for the '<em><b>C3</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EROW__C3 = 2;

  /**
   * The feature id for the '<em><b>C4</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EROW__C4 = 3;

  /**
   * The feature id for the '<em><b>C5</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EROW__C5 = 4;

  /**
   * The feature id for the '<em><b>C6</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EROW__C6 = 5;

  /**
   * The feature id for the '<em><b>C7</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EROW__C7 = 6;

  /**
   * The feature id for the '<em><b>C8</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EROW__C8 = 7;

  /**
   * The number of structural features of the '<em>ERow</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EROW_FEATURE_COUNT = 8;

  /**
   * The meta object id for the '{@link no.pdigre.pSQT.PieceType <em>Piece Type</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see no.pdigre.pSQT.PieceType
   * @see no.pdigre.pSQT.impl.PSQTPackageImpl#getPieceType()
   * @generated
   */
  int PIECE_TYPE = 7;


  /**
   * Returns the meta object for class '{@link no.pdigre.pSQT.PSQT_Model <em>PSQT Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>PSQT Model</em>'.
   * @see no.pdigre.pSQT.PSQT_Model
   * @generated
   */
  EClass getPSQT_Model();

  /**
   * Returns the meta object for class '{@link no.pdigre.pSQT.FDescription <em>FDescription</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>FDescription</em>'.
   * @see no.pdigre.pSQT.FDescription
   * @generated
   */
  EClass getFDescription();

  /**
   * Returns the meta object for the containment reference list '{@link no.pdigre.pSQT.FDescription#getTables <em>Tables</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Tables</em>'.
   * @see no.pdigre.pSQT.FDescription#getTables()
   * @see #getFDescription()
   * @generated
   */
  EReference getFDescription_Tables();

  /**
   * Returns the meta object for the attribute '{@link no.pdigre.pSQT.FDescription#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see no.pdigre.pSQT.FDescription#getName()
   * @see #getFDescription()
   * @generated
   */
  EAttribute getFDescription_Name();

  /**
   * Returns the meta object for the attribute '{@link no.pdigre.pSQT.FDescription#getBase <em>Base</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Base</em>'.
   * @see no.pdigre.pSQT.FDescription#getBase()
   * @see #getFDescription()
   * @generated
   */
  EAttribute getFDescription_Base();

  /**
   * Returns the meta object for the attribute '{@link no.pdigre.pSQT.FDescription#getMgl <em>Mgl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Mgl</em>'.
   * @see no.pdigre.pSQT.FDescription#getMgl()
   * @see #getFDescription()
   * @generated
   */
  EAttribute getFDescription_Mgl();

  /**
   * Returns the meta object for the attribute '{@link no.pdigre.pSQT.FDescription#getEgl <em>Egl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Egl</em>'.
   * @see no.pdigre.pSQT.FDescription#getEgl()
   * @see #getFDescription()
   * @generated
   */
  EAttribute getFDescription_Egl();

  /**
   * Returns the meta object for class '{@link no.pdigre.pSQT.Table <em>Table</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Table</em>'.
   * @see no.pdigre.pSQT.Table
   * @generated
   */
  EClass getTable();

  /**
   * Returns the meta object for class '{@link no.pdigre.pSQT.TDescription <em>TDescription</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TDescription</em>'.
   * @see no.pdigre.pSQT.TDescription
   * @generated
   */
  EClass getTDescription();

  /**
   * Returns the meta object for the containment reference list '{@link no.pdigre.pSQT.TDescription#getR <em>R</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>R</em>'.
   * @see no.pdigre.pSQT.TDescription#getR()
   * @see #getTDescription()
   * @generated
   */
  EReference getTDescription_R();

  /**
   * Returns the meta object for the attribute '{@link no.pdigre.pSQT.TDescription#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see no.pdigre.pSQT.TDescription#getName()
   * @see #getTDescription()
   * @generated
   */
  EAttribute getTDescription_Name();

  /**
   * Returns the meta object for the attribute '{@link no.pdigre.pSQT.TDescription#getMg <em>Mg</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Mg</em>'.
   * @see no.pdigre.pSQT.TDescription#getMg()
   * @see #getTDescription()
   * @generated
   */
  EAttribute getTDescription_Mg();

  /**
   * Returns the meta object for the attribute '{@link no.pdigre.pSQT.TDescription#getEg <em>Eg</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Eg</em>'.
   * @see no.pdigre.pSQT.TDescription#getEg()
   * @see #getTDescription()
   * @generated
   */
  EAttribute getTDescription_Eg();

  /**
   * Returns the meta object for class '{@link no.pdigre.pSQT.Row <em>Row</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Row</em>'.
   * @see no.pdigre.pSQT.Row
   * @generated
   */
  EClass getRow();

  /**
   * Returns the meta object for the attribute '{@link no.pdigre.pSQT.Row#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see no.pdigre.pSQT.Row#getName()
   * @see #getRow()
   * @generated
   */
  EAttribute getRow_Name();

  /**
   * Returns the meta object for the containment reference '{@link no.pdigre.pSQT.Row#getMidrow <em>Midrow</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Midrow</em>'.
   * @see no.pdigre.pSQT.Row#getMidrow()
   * @see #getRow()
   * @generated
   */
  EReference getRow_Midrow();

  /**
   * Returns the meta object for the containment reference '{@link no.pdigre.pSQT.Row#getEndrow <em>Endrow</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Endrow</em>'.
   * @see no.pdigre.pSQT.Row#getEndrow()
   * @see #getRow()
   * @generated
   */
  EReference getRow_Endrow();

  /**
   * Returns the meta object for class '{@link no.pdigre.pSQT.MRow <em>MRow</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MRow</em>'.
   * @see no.pdigre.pSQT.MRow
   * @generated
   */
  EClass getMRow();

  /**
   * Returns the meta object for the attribute '{@link no.pdigre.pSQT.MRow#getC1 <em>C1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>C1</em>'.
   * @see no.pdigre.pSQT.MRow#getC1()
   * @see #getMRow()
   * @generated
   */
  EAttribute getMRow_C1();

  /**
   * Returns the meta object for the attribute '{@link no.pdigre.pSQT.MRow#getC2 <em>C2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>C2</em>'.
   * @see no.pdigre.pSQT.MRow#getC2()
   * @see #getMRow()
   * @generated
   */
  EAttribute getMRow_C2();

  /**
   * Returns the meta object for the attribute '{@link no.pdigre.pSQT.MRow#getC3 <em>C3</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>C3</em>'.
   * @see no.pdigre.pSQT.MRow#getC3()
   * @see #getMRow()
   * @generated
   */
  EAttribute getMRow_C3();

  /**
   * Returns the meta object for the attribute '{@link no.pdigre.pSQT.MRow#getC4 <em>C4</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>C4</em>'.
   * @see no.pdigre.pSQT.MRow#getC4()
   * @see #getMRow()
   * @generated
   */
  EAttribute getMRow_C4();

  /**
   * Returns the meta object for the attribute '{@link no.pdigre.pSQT.MRow#getC5 <em>C5</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>C5</em>'.
   * @see no.pdigre.pSQT.MRow#getC5()
   * @see #getMRow()
   * @generated
   */
  EAttribute getMRow_C5();

  /**
   * Returns the meta object for the attribute '{@link no.pdigre.pSQT.MRow#getC6 <em>C6</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>C6</em>'.
   * @see no.pdigre.pSQT.MRow#getC6()
   * @see #getMRow()
   * @generated
   */
  EAttribute getMRow_C6();

  /**
   * Returns the meta object for the attribute '{@link no.pdigre.pSQT.MRow#getC7 <em>C7</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>C7</em>'.
   * @see no.pdigre.pSQT.MRow#getC7()
   * @see #getMRow()
   * @generated
   */
  EAttribute getMRow_C7();

  /**
   * Returns the meta object for the attribute '{@link no.pdigre.pSQT.MRow#getC8 <em>C8</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>C8</em>'.
   * @see no.pdigre.pSQT.MRow#getC8()
   * @see #getMRow()
   * @generated
   */
  EAttribute getMRow_C8();

  /**
   * Returns the meta object for class '{@link no.pdigre.pSQT.ERow <em>ERow</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>ERow</em>'.
   * @see no.pdigre.pSQT.ERow
   * @generated
   */
  EClass getERow();

  /**
   * Returns the meta object for the attribute '{@link no.pdigre.pSQT.ERow#getC1 <em>C1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>C1</em>'.
   * @see no.pdigre.pSQT.ERow#getC1()
   * @see #getERow()
   * @generated
   */
  EAttribute getERow_C1();

  /**
   * Returns the meta object for the attribute '{@link no.pdigre.pSQT.ERow#getC2 <em>C2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>C2</em>'.
   * @see no.pdigre.pSQT.ERow#getC2()
   * @see #getERow()
   * @generated
   */
  EAttribute getERow_C2();

  /**
   * Returns the meta object for the attribute '{@link no.pdigre.pSQT.ERow#getC3 <em>C3</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>C3</em>'.
   * @see no.pdigre.pSQT.ERow#getC3()
   * @see #getERow()
   * @generated
   */
  EAttribute getERow_C3();

  /**
   * Returns the meta object for the attribute '{@link no.pdigre.pSQT.ERow#getC4 <em>C4</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>C4</em>'.
   * @see no.pdigre.pSQT.ERow#getC4()
   * @see #getERow()
   * @generated
   */
  EAttribute getERow_C4();

  /**
   * Returns the meta object for the attribute '{@link no.pdigre.pSQT.ERow#getC5 <em>C5</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>C5</em>'.
   * @see no.pdigre.pSQT.ERow#getC5()
   * @see #getERow()
   * @generated
   */
  EAttribute getERow_C5();

  /**
   * Returns the meta object for the attribute '{@link no.pdigre.pSQT.ERow#getC6 <em>C6</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>C6</em>'.
   * @see no.pdigre.pSQT.ERow#getC6()
   * @see #getERow()
   * @generated
   */
  EAttribute getERow_C6();

  /**
   * Returns the meta object for the attribute '{@link no.pdigre.pSQT.ERow#getC7 <em>C7</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>C7</em>'.
   * @see no.pdigre.pSQT.ERow#getC7()
   * @see #getERow()
   * @generated
   */
  EAttribute getERow_C7();

  /**
   * Returns the meta object for the attribute '{@link no.pdigre.pSQT.ERow#getC8 <em>C8</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>C8</em>'.
   * @see no.pdigre.pSQT.ERow#getC8()
   * @see #getERow()
   * @generated
   */
  EAttribute getERow_C8();

  /**
   * Returns the meta object for enum '{@link no.pdigre.pSQT.PieceType <em>Piece Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Piece Type</em>'.
   * @see no.pdigre.pSQT.PieceType
   * @generated
   */
  EEnum getPieceType();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  PSQTFactory getPSQTFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link no.pdigre.pSQT.impl.PSQT_ModelImpl <em>PSQT Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see no.pdigre.pSQT.impl.PSQT_ModelImpl
     * @see no.pdigre.pSQT.impl.PSQTPackageImpl#getPSQT_Model()
     * @generated
     */
    EClass PSQT_MODEL = eINSTANCE.getPSQT_Model();

    /**
     * The meta object literal for the '{@link no.pdigre.pSQT.impl.FDescriptionImpl <em>FDescription</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see no.pdigre.pSQT.impl.FDescriptionImpl
     * @see no.pdigre.pSQT.impl.PSQTPackageImpl#getFDescription()
     * @generated
     */
    EClass FDESCRIPTION = eINSTANCE.getFDescription();

    /**
     * The meta object literal for the '<em><b>Tables</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FDESCRIPTION__TABLES = eINSTANCE.getFDescription_Tables();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FDESCRIPTION__NAME = eINSTANCE.getFDescription_Name();

    /**
     * The meta object literal for the '<em><b>Base</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FDESCRIPTION__BASE = eINSTANCE.getFDescription_Base();

    /**
     * The meta object literal for the '<em><b>Mgl</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FDESCRIPTION__MGL = eINSTANCE.getFDescription_Mgl();

    /**
     * The meta object literal for the '<em><b>Egl</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FDESCRIPTION__EGL = eINSTANCE.getFDescription_Egl();

    /**
     * The meta object literal for the '{@link no.pdigre.pSQT.impl.TableImpl <em>Table</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see no.pdigre.pSQT.impl.TableImpl
     * @see no.pdigre.pSQT.impl.PSQTPackageImpl#getTable()
     * @generated
     */
    EClass TABLE = eINSTANCE.getTable();

    /**
     * The meta object literal for the '{@link no.pdigre.pSQT.impl.TDescriptionImpl <em>TDescription</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see no.pdigre.pSQT.impl.TDescriptionImpl
     * @see no.pdigre.pSQT.impl.PSQTPackageImpl#getTDescription()
     * @generated
     */
    EClass TDESCRIPTION = eINSTANCE.getTDescription();

    /**
     * The meta object literal for the '<em><b>R</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TDESCRIPTION__R = eINSTANCE.getTDescription_R();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TDESCRIPTION__NAME = eINSTANCE.getTDescription_Name();

    /**
     * The meta object literal for the '<em><b>Mg</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TDESCRIPTION__MG = eINSTANCE.getTDescription_Mg();

    /**
     * The meta object literal for the '<em><b>Eg</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TDESCRIPTION__EG = eINSTANCE.getTDescription_Eg();

    /**
     * The meta object literal for the '{@link no.pdigre.pSQT.impl.RowImpl <em>Row</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see no.pdigre.pSQT.impl.RowImpl
     * @see no.pdigre.pSQT.impl.PSQTPackageImpl#getRow()
     * @generated
     */
    EClass ROW = eINSTANCE.getRow();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ROW__NAME = eINSTANCE.getRow_Name();

    /**
     * The meta object literal for the '<em><b>Midrow</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ROW__MIDROW = eINSTANCE.getRow_Midrow();

    /**
     * The meta object literal for the '<em><b>Endrow</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ROW__ENDROW = eINSTANCE.getRow_Endrow();

    /**
     * The meta object literal for the '{@link no.pdigre.pSQT.impl.MRowImpl <em>MRow</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see no.pdigre.pSQT.impl.MRowImpl
     * @see no.pdigre.pSQT.impl.PSQTPackageImpl#getMRow()
     * @generated
     */
    EClass MROW = eINSTANCE.getMRow();

    /**
     * The meta object literal for the '<em><b>C1</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MROW__C1 = eINSTANCE.getMRow_C1();

    /**
     * The meta object literal for the '<em><b>C2</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MROW__C2 = eINSTANCE.getMRow_C2();

    /**
     * The meta object literal for the '<em><b>C3</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MROW__C3 = eINSTANCE.getMRow_C3();

    /**
     * The meta object literal for the '<em><b>C4</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MROW__C4 = eINSTANCE.getMRow_C4();

    /**
     * The meta object literal for the '<em><b>C5</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MROW__C5 = eINSTANCE.getMRow_C5();

    /**
     * The meta object literal for the '<em><b>C6</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MROW__C6 = eINSTANCE.getMRow_C6();

    /**
     * The meta object literal for the '<em><b>C7</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MROW__C7 = eINSTANCE.getMRow_C7();

    /**
     * The meta object literal for the '<em><b>C8</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MROW__C8 = eINSTANCE.getMRow_C8();

    /**
     * The meta object literal for the '{@link no.pdigre.pSQT.impl.ERowImpl <em>ERow</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see no.pdigre.pSQT.impl.ERowImpl
     * @see no.pdigre.pSQT.impl.PSQTPackageImpl#getERow()
     * @generated
     */
    EClass EROW = eINSTANCE.getERow();

    /**
     * The meta object literal for the '<em><b>C1</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EROW__C1 = eINSTANCE.getERow_C1();

    /**
     * The meta object literal for the '<em><b>C2</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EROW__C2 = eINSTANCE.getERow_C2();

    /**
     * The meta object literal for the '<em><b>C3</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EROW__C3 = eINSTANCE.getERow_C3();

    /**
     * The meta object literal for the '<em><b>C4</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EROW__C4 = eINSTANCE.getERow_C4();

    /**
     * The meta object literal for the '<em><b>C5</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EROW__C5 = eINSTANCE.getERow_C5();

    /**
     * The meta object literal for the '<em><b>C6</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EROW__C6 = eINSTANCE.getERow_C6();

    /**
     * The meta object literal for the '<em><b>C7</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EROW__C7 = eINSTANCE.getERow_C7();

    /**
     * The meta object literal for the '<em><b>C8</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EROW__C8 = eINSTANCE.getERow_C8();

    /**
     * The meta object literal for the '{@link no.pdigre.pSQT.PieceType <em>Piece Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see no.pdigre.pSQT.PieceType
     * @see no.pdigre.pSQT.impl.PSQTPackageImpl#getPieceType()
     * @generated
     */
    EEnum PIECE_TYPE = eINSTANCE.getPieceType();

  }

} //PSQTPackage
