/**
 */
package no.pdigre.pSQT;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Row1</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.pdigre.pSQT.Row1#getC <em>C</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.pdigre.pSQT.PSQTPackage#getRow1()
 * @model
 * @generated
 */
public interface Row1 extends EObject
{
  /**
   * Returns the value of the '<em><b>C</b></em>' attribute list.
   * The list contents are of type {@link java.lang.Integer}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>C</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>C</em>' attribute list.
   * @see no.pdigre.pSQT.PSQTPackage#getRow1_C()
   * @model unique="false"
   * @generated
   */
  EList<Integer> getC();

} // Row1
