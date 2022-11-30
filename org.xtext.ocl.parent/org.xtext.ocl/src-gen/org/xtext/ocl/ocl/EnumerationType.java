/**
 * generated by Xtext 2.26.0-SNAPSHOT
 */
package org.xtext.ocl.ocl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enumeration Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.ocl.ocl.EnumerationType#getLeft <em>Left</em>}</li>
 *   <li>{@link org.xtext.ocl.ocl.EnumerationType#getRights <em>Rights</em>}</li>
 * </ul>
 *
 * @see org.xtext.ocl.ocl.OclPackage#getEnumerationType()
 * @model
 * @generated
 */
public interface EnumerationType extends SimpleTypeSpecifier
{
  /**
   * Returns the value of the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Left</em>' containment reference.
   * @see #setLeft(Name)
   * @see org.xtext.ocl.ocl.OclPackage#getEnumerationType_Left()
   * @model containment="true"
   * @generated
   */
  Name getLeft();

  /**
   * Sets the value of the '{@link org.xtext.ocl.ocl.EnumerationType#getLeft <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left</em>' containment reference.
   * @see #getLeft()
   * @generated
   */
  void setLeft(Name value);

  /**
   * Returns the value of the '<em><b>Rights</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.ocl.ocl.Name}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rights</em>' containment reference list.
   * @see org.xtext.ocl.ocl.OclPackage#getEnumerationType_Rights()
   * @model containment="true"
   * @generated
   */
  EList<Name> getRights();

} // EnumerationType
