/**
 * generated by Xtext 2.26.0-SNAPSHOT
 */
package org.xtext.ocl.ocl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.ocl.ocl.Literal#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see org.xtext.ocl.ocl.OclPackage#getLiteral()
 * @model
 * @generated
 */
public interface Literal extends PrimaryExpression
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.xtext.ocl.ocl.OclPackage#getLiteral_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.xtext.ocl.ocl.Literal#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

} // Literal