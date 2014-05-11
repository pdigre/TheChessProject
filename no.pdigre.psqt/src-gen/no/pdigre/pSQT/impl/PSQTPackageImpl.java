/**
 */
package no.pdigre.pSQT.impl;

import no.pdigre.pSQT.ERow;
import no.pdigre.pSQT.FDescription;
import no.pdigre.pSQT.MRow;
import no.pdigre.pSQT.PSQTFactory;
import no.pdigre.pSQT.PSQTPackage;
import no.pdigre.pSQT.PSQT_Model;
import no.pdigre.pSQT.PieceType;
import no.pdigre.pSQT.Row;
import no.pdigre.pSQT.TDescription;
import no.pdigre.pSQT.Table;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PSQTPackageImpl extends EPackageImpl implements PSQTPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass psqT_ModelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass fDescriptionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tableEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tDescriptionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass rowEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mRowEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass eRowEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum pieceTypeEEnum = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see no.pdigre.pSQT.PSQTPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private PSQTPackageImpl()
  {
    super(eNS_URI, PSQTFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link PSQTPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static PSQTPackage init()
  {
    if (isInited) return (PSQTPackage)EPackage.Registry.INSTANCE.getEPackage(PSQTPackage.eNS_URI);

    // Obtain or create and register package
    PSQTPackageImpl thePSQTPackage = (PSQTPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof PSQTPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new PSQTPackageImpl());

    isInited = true;

    // Create package meta-data objects
    thePSQTPackage.createPackageContents();

    // Initialize created meta-data
    thePSQTPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    thePSQTPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(PSQTPackage.eNS_URI, thePSQTPackage);
    return thePSQTPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPSQT_Model()
  {
    return psqT_ModelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFDescription()
  {
    return fDescriptionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFDescription_Tables()
  {
    return (EReference)fDescriptionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFDescription_Name()
  {
    return (EAttribute)fDescriptionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFDescription_Base()
  {
    return (EAttribute)fDescriptionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFDescription_Mgl()
  {
    return (EAttribute)fDescriptionEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFDescription_Egl()
  {
    return (EAttribute)fDescriptionEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTable()
  {
    return tableEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTDescription()
  {
    return tDescriptionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTDescription_R()
  {
    return (EReference)tDescriptionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTDescription_Name()
  {
    return (EAttribute)tDescriptionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTDescription_Mg()
  {
    return (EAttribute)tDescriptionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTDescription_Eg()
  {
    return (EAttribute)tDescriptionEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRow()
  {
    return rowEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRow_Name()
  {
    return (EAttribute)rowEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRow_Midrow()
  {
    return (EReference)rowEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRow_Endrow()
  {
    return (EReference)rowEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMRow()
  {
    return mRowEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMRow_C1()
  {
    return (EAttribute)mRowEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMRow_C2()
  {
    return (EAttribute)mRowEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMRow_C3()
  {
    return (EAttribute)mRowEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMRow_C4()
  {
    return (EAttribute)mRowEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMRow_C5()
  {
    return (EAttribute)mRowEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMRow_C6()
  {
    return (EAttribute)mRowEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMRow_C7()
  {
    return (EAttribute)mRowEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMRow_C8()
  {
    return (EAttribute)mRowEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getERow()
  {
    return eRowEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getERow_C1()
  {
    return (EAttribute)eRowEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getERow_C2()
  {
    return (EAttribute)eRowEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getERow_C3()
  {
    return (EAttribute)eRowEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getERow_C4()
  {
    return (EAttribute)eRowEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getERow_C5()
  {
    return (EAttribute)eRowEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getERow_C6()
  {
    return (EAttribute)eRowEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getERow_C7()
  {
    return (EAttribute)eRowEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getERow_C8()
  {
    return (EAttribute)eRowEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getPieceType()
  {
    return pieceTypeEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PSQTFactory getPSQTFactory()
  {
    return (PSQTFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    psqT_ModelEClass = createEClass(PSQT_MODEL);

    fDescriptionEClass = createEClass(FDESCRIPTION);
    createEReference(fDescriptionEClass, FDESCRIPTION__TABLES);
    createEAttribute(fDescriptionEClass, FDESCRIPTION__NAME);
    createEAttribute(fDescriptionEClass, FDESCRIPTION__BASE);
    createEAttribute(fDescriptionEClass, FDESCRIPTION__MGL);
    createEAttribute(fDescriptionEClass, FDESCRIPTION__EGL);

    tableEClass = createEClass(TABLE);

    tDescriptionEClass = createEClass(TDESCRIPTION);
    createEReference(tDescriptionEClass, TDESCRIPTION__R);
    createEAttribute(tDescriptionEClass, TDESCRIPTION__NAME);
    createEAttribute(tDescriptionEClass, TDESCRIPTION__MG);
    createEAttribute(tDescriptionEClass, TDESCRIPTION__EG);

    rowEClass = createEClass(ROW);
    createEAttribute(rowEClass, ROW__NAME);
    createEReference(rowEClass, ROW__MIDROW);
    createEReference(rowEClass, ROW__ENDROW);

    mRowEClass = createEClass(MROW);
    createEAttribute(mRowEClass, MROW__C1);
    createEAttribute(mRowEClass, MROW__C2);
    createEAttribute(mRowEClass, MROW__C3);
    createEAttribute(mRowEClass, MROW__C4);
    createEAttribute(mRowEClass, MROW__C5);
    createEAttribute(mRowEClass, MROW__C6);
    createEAttribute(mRowEClass, MROW__C7);
    createEAttribute(mRowEClass, MROW__C8);

    eRowEClass = createEClass(EROW);
    createEAttribute(eRowEClass, EROW__C1);
    createEAttribute(eRowEClass, EROW__C2);
    createEAttribute(eRowEClass, EROW__C3);
    createEAttribute(eRowEClass, EROW__C4);
    createEAttribute(eRowEClass, EROW__C5);
    createEAttribute(eRowEClass, EROW__C6);
    createEAttribute(eRowEClass, EROW__C7);
    createEAttribute(eRowEClass, EROW__C8);

    // Create enums
    pieceTypeEEnum = createEEnum(PIECE_TYPE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    fDescriptionEClass.getESuperTypes().add(this.getPSQT_Model());
    tDescriptionEClass.getESuperTypes().add(this.getTable());

    // Initialize classes and features; add operations and parameters
    initEClass(psqT_ModelEClass, PSQT_Model.class, "PSQT_Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(fDescriptionEClass, FDescription.class, "FDescription", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFDescription_Tables(), this.getTable(), null, "tables", null, 0, -1, FDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getFDescription_Name(), ecorePackage.getEString(), "name", null, 0, 1, FDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getFDescription_Base(), ecorePackage.getEInt(), "base", null, 0, 1, FDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getFDescription_Mgl(), ecorePackage.getEInt(), "mgl", null, 0, 1, FDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getFDescription_Egl(), ecorePackage.getEInt(), "egl", null, 0, 1, FDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(tableEClass, Table.class, "Table", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(tDescriptionEClass, TDescription.class, "TDescription", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTDescription_R(), this.getRow(), null, "r", null, 0, -1, TDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTDescription_Name(), this.getPieceType(), "name", null, 0, 1, TDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTDescription_Mg(), ecorePackage.getEInt(), "mg", null, 0, 1, TDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTDescription_Eg(), ecorePackage.getEInt(), "eg", null, 0, 1, TDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(rowEClass, Row.class, "Row", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRow_Name(), ecorePackage.getEString(), "name", null, 0, 1, Row.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRow_Midrow(), this.getMRow(), null, "midrow", null, 0, 1, Row.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRow_Endrow(), this.getERow(), null, "endrow", null, 0, 1, Row.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mRowEClass, MRow.class, "MRow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMRow_C1(), ecorePackage.getEInt(), "c1", null, 0, 1, MRow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMRow_C2(), ecorePackage.getEInt(), "c2", null, 0, 1, MRow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMRow_C3(), ecorePackage.getEInt(), "c3", null, 0, 1, MRow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMRow_C4(), ecorePackage.getEInt(), "c4", null, 0, 1, MRow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMRow_C5(), ecorePackage.getEInt(), "c5", null, 0, 1, MRow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMRow_C6(), ecorePackage.getEInt(), "c6", null, 0, 1, MRow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMRow_C7(), ecorePackage.getEInt(), "c7", null, 0, 1, MRow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMRow_C8(), ecorePackage.getEInt(), "c8", null, 0, 1, MRow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(eRowEClass, ERow.class, "ERow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getERow_C1(), ecorePackage.getEInt(), "c1", null, 0, 1, ERow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getERow_C2(), ecorePackage.getEInt(), "c2", null, 0, 1, ERow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getERow_C3(), ecorePackage.getEInt(), "c3", null, 0, 1, ERow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getERow_C4(), ecorePackage.getEInt(), "c4", null, 0, 1, ERow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getERow_C5(), ecorePackage.getEInt(), "c5", null, 0, 1, ERow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getERow_C6(), ecorePackage.getEInt(), "c6", null, 0, 1, ERow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getERow_C7(), ecorePackage.getEInt(), "c7", null, 0, 1, ERow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getERow_C8(), ecorePackage.getEInt(), "c8", null, 0, 1, ERow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(pieceTypeEEnum, PieceType.class, "PieceType");
    addEEnumLiteral(pieceTypeEEnum, PieceType.PAWN);
    addEEnumLiteral(pieceTypeEEnum, PieceType.KNIGHT);
    addEEnumLiteral(pieceTypeEEnum, PieceType.BISHOP);
    addEEnumLiteral(pieceTypeEEnum, PieceType.ROOK);
    addEEnumLiteral(pieceTypeEEnum, PieceType.QUEEN);
    addEEnumLiteral(pieceTypeEEnum, PieceType.KING);

    // Create resource
    createResource(eNS_URI);
  }

} //PSQTPackageImpl
