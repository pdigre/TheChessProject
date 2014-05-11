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
   * The meta object id for the '{@link no.pdigre.pSQT.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see no.pdigre.pSQT.impl.ModelImpl
   * @see no.pdigre.pSQT.impl.PSQTPackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 0;

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
  int FDESCRIPTION__TABLES = MODEL_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FDESCRIPTION__NAME = MODEL_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Base</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FDESCRIPTION__BASE = MODEL_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Mgl</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FDESCRIPTION__MGL = MODEL_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Egl</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FDESCRIPTION__EGL = MODEL_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>FDescription</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FDESCRIPTION_FEATURE_COUNT = MODEL_FEATURE_COUNT + 5;

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
   * The feature id for the '<em><b>M</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROW__M = 1;

  /**
   * The feature id for the '<em><b>E</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROW__E = 2;

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
   * The feature id for the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MROW__NAME = 0;

  /**
   * The number of structural features of the '<em>MRow</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MROW_FEATURE_COUNT = 1;

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
   * The feature id for the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EROW__NAME = 0;

  /**
   * The number of structural features of the '<em>ERow</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EROW_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link no.pdigre.pSQT.impl.Row1Impl <em>Row1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see no.pdigre.pSQT.impl.Row1Impl
   * @see no.pdigre.pSQT.impl.PSQTPackageImpl#getRow1()
   * @generated
   */
  int ROW1 = 7;

  /**
   * The feature id for the '<em><b>C</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROW1__C = 0;

  /**
   * The number of structural features of the '<em>Row1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROW1_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link no.pdigre.pSQT.PieceType <em>Piece Type</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see no.pdigre.pSQT.PieceType
   * @see no.pdigre.pSQT.impl.PSQTPackageImpl#getPieceType()
   * @generated
   */
  int PIECE_TYPE = 8;


  /**
   * Returns the meta object for class '{@link no.pdigre.pSQT.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see no.pdigre.pSQT.Model
   * @generated
   */
  EClass getModel();

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
   * Returns the meta object for the containment reference '{@link no.pdigre.pSQT.Row#getM <em>M</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>M</em>'.
   * @see no.pdigre.pSQT.Row#getM()
   * @see #getRow()
   * @generated
   */
  EReference getRow_M();

  /**
   * Returns the meta object for the containment reference '{@link no.pdigre.pSQT.Row#getE <em>E</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>E</em>'.
   * @see no.pdigre.pSQT.Row#getE()
   * @see #getRow()
   * @generated
   */
  EReference getRow_E();

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
   * Returns the meta object for the containment reference '{@link no.pdigre.pSQT.MRow#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name</em>'.
   * @see no.pdigre.pSQT.MRow#getName()
   * @see #getMRow()
   * @generated
   */
  EReference getMRow_Name();

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
   * Returns the meta object for the containment reference '{@link no.pdigre.pSQT.ERow#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name</em>'.
   * @see no.pdigre.pSQT.ERow#getName()
   * @see #getERow()
   * @generated
   */
  EReference getERow_Name();

  /**
   * Returns the meta object for class '{@link no.pdigre.pSQT.Row1 <em>Row1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Row1</em>'.
   * @see no.pdigre.pSQT.Row1
   * @generated
   */
  EClass getRow1();

  /**
   * Returns the meta object for the attribute list '{@link no.pdigre.pSQT.Row1#getC <em>C</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>C</em>'.
   * @see no.pdigre.pSQT.Row1#getC()
   * @see #getRow1()
   * @generated
   */
  EAttribute getRow1_C();

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
     * The meta object literal for the '{@link no.pdigre.pSQT.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see no.pdigre.pSQT.impl.ModelImpl
     * @see no.pdigre.pSQT.impl.PSQTPackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

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
     * The meta object literal for the '<em><b>M</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ROW__M = eINSTANCE.getRow_M();

    /**
     * The meta object literal for the '<em><b>E</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ROW__E = eINSTANCE.getRow_E();

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
     * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MROW__NAME = eINSTANCE.getMRow_Name();

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
     * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EROW__NAME = eINSTANCE.getERow_Name();

    /**
     * The meta object literal for the '{@link no.pdigre.pSQT.impl.Row1Impl <em>Row1</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see no.pdigre.pSQT.impl.Row1Impl
     * @see no.pdigre.pSQT.impl.PSQTPackageImpl#getRow1()
     * @generated
     */
    EClass ROW1 = eINSTANCE.getRow1();

    /**
     * The meta object literal for the '<em><b>C</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ROW1__C = eINSTANCE.getRow1_C();

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
