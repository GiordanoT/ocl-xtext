/**
 * generated by Xtext 2.26.0-SNAPSHOT
 */
package org.xtext.ocl.ocl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primary Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.ocl.ocl.PrimaryExpression#getOp <em>Op</em>}</li>
 *   <li>{@link org.xtext.ocl.ocl.PrimaryExpression#getFeatures <em>Features</em>}</li>
 * </ul>
 *
 * @see org.xtext.ocl.ocl.OclPackage#getPrimaryExpression()
 * @model
 * @generated
 */
public interface PrimaryExpression extends PostfixExpression
{
  /**
   * Returns the value of the '<em><b>Op</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Op</em>' containment reference list.
   * @see org.xtext.ocl.ocl.OclPackage#getPrimaryExpression_Op()
   * @model containment="true"
   * @generated
   */
  EList<EObject> getOp();

  /**
   * Returns the value of the '<em><b>Features</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.ocl.ocl.FeatureCall}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Features</em>' containment reference list.
   * @see org.xtext.ocl.ocl.OclPackage#getPrimaryExpression_Features()
   * @model containment="true"
   * @generated
   */
  EList<FeatureCall> getFeatures();

} // PrimaryExpression
