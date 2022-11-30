/**
 * generated by Xtext 2.26.0-SNAPSHOT
 */
package org.xtext.ocl.ocl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Additive Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.ocl.ocl.AdditiveExpression#getExp <em>Exp</em>}</li>
 *   <li>{@link org.xtext.ocl.ocl.AdditiveExpression#getOp <em>Op</em>}</li>
 * </ul>
 *
 * @see org.xtext.ocl.ocl.OclPackage#getAdditiveExpression()
 * @model
 * @generated
 */
public interface AdditiveExpression extends EObject
{
  /**
   * Returns the value of the '<em><b>Exp</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.ocl.ocl.MultiplicativeExpression}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Exp</em>' containment reference list.
   * @see org.xtext.ocl.ocl.OclPackage#getAdditiveExpression_Exp()
   * @model containment="true"
   * @generated
   */
  EList<MultiplicativeExpression> getExp();

  /**
   * Returns the value of the '<em><b>Op</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.ocl.ocl.AddOperator}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Op</em>' containment reference list.
   * @see org.xtext.ocl.ocl.OclPackage#getAdditiveExpression_Op()
   * @model containment="true"
   * @generated
   */
  EList<AddOperator> getOp();

} // AdditiveExpression
