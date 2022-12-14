/**
 * generated by Xtext 2.26.0-SNAPSHOT
 */
package org.xtext.ocl.ocl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>If Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.ocl.ocl.IfExpression#getExp <em>Exp</em>}</li>
 * </ul>
 *
 * @see org.xtext.ocl.ocl.OclPackage#getIfExpression()
 * @model
 * @generated
 */
public interface IfExpression extends PrimaryExpression
{
  /**
   * Returns the value of the '<em><b>Exp</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.ocl.ocl.Expression}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Exp</em>' containment reference list.
   * @see org.xtext.ocl.ocl.OclPackage#getIfExpression_Exp()
   * @model containment="true"
   * @generated
   */
  EList<Expression> getExp();

} // IfExpression
