/**
 */
package no.pdigre.pSQT;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TDescription</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.pdigre.pSQT.TDescription#getR <em>R</em>}</li>
 *   <li>{@link no.pdigre.pSQT.TDescription#getName <em>Name</em>}</li>
 *   <li>{@link no.pdigre.pSQT.TDescription#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.pdigre.pSQT.PSQTPackage#getTDescription()
 * @model
 * @generated
 */
public interface TDescription extends Table
{
  /**
   * Returns the value of the '<em><b>R</b></em>' containment reference list.
   * The list contents are of type {@link no.pdigre.pSQT.Row}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>R</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>R</em>' containment reference list.
   * @see no.pdigre.pSQT.PSQTPackage#getTDescription_R()
   * @model containment="true"
   * @generated
   */
  EList<Row> getR();

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * The literals are from the enumeration {@link no.pdigre.pSQT.PieceType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see no.pdigre.pSQT.PieceType
   * @see #setName(PieceType)
   * @see no.pdigre.pSQT.PSQTPackage#getTDescription_Name()
   * @model
   * @generated
   */
  PieceType getName();

  /**
   * Sets the value of the '{@link no.pdigre.pSQT.TDescription#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see no.pdigre.pSQT.PieceType
   * @see #getName()
   * @generated
   */
  void setName(PieceType value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' attribute.
   * @see #setValue(int)
   * @see no.pdigre.pSQT.PSQTPackage#getTDescription_Value()
   * @model
   * @generated
   */
  int getValue();

  /**
   * Sets the value of the '{@link no.pdigre.pSQT.TDescription#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see #getValue()
   * @generated
   */
  void setValue(int value);

} // TDescription
