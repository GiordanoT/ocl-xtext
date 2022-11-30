/**
 * generated by Xtext 2.26.0-SNAPSHOT
 */
package org.xtext.ocl.ocl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unary Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.ocl.ocl.UnaryExpression#getOp <em>Op</em>}</li>
 *   <li>{@link org.xtext.ocl.ocl.UnaryExpression#getExp <em>Exp</em>}</li>
 * </ul>
 *
 * @see org.xtext.ocl.ocl.OclPackage#getUnaryExpression()
 * @model
 * @generated
 */
public interface UnaryExpression extends EObject
{
  /**
   * Returns the value of the '<em><b>Op</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.ocl.ocl.UnaryOperator}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Op</em>' containment reference list.
   * @see org.xtext.ocl.ocl.OclPackage#getUnaryExpression_Op()
   * @model containment="true"
   * @generated
   */
  EList<UnaryOperator> getOp();

  /**
   * Returns the value of the '<em><b>Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Exp</em>' containment reference.
   * @see #setExp(PostfixExpression)
   * @see org.xtext.ocl.ocl.OclPackage#getUnaryExpression_Exp()
   * @model containment="true"
   * @generated
   */
  PostfixExpression getExp();

  /**
   * Sets the value of the '{@link org.xtext.ocl.ocl.UnaryExpression#getExp <em>Exp</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Exp</em>' containment reference.
   * @see #getExp()
   * @generated
   */
  void setExp(PostfixExpression value);

} // UnaryExpression
