/**
 */
package no.pdigre.pSQT;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MRow</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.pdigre.pSQT.MRow#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.pdigre.pSQT.PSQTPackage#getMRow()
 * @model
 * @generated
 */
public interface MRow extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' containment reference.
   * @see #setName(Row1)
   * @see no.pdigre.pSQT.PSQTPackage#getMRow_Name()
   * @model containment="true"
   * @generated
   */
  Row1 getName();

  /**
   * Sets the value of the '{@link no.pdigre.pSQT.MRow#getName <em>Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' containment reference.
   * @see #getName()
   * @generated
   */
  void setName(Row1 value);

} // MRow
