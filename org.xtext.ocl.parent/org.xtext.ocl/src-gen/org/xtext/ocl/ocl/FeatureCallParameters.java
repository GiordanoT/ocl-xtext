/**
 * generated by Xtext 2.26.0-SNAPSHOT
 */
package org.xtext.ocl.ocl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature Call Parameters</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.ocl.ocl.FeatureCallParameters#getDecs <em>Decs</em>}</li>
 *   <li>{@link org.xtext.ocl.ocl.FeatureCallParameters#getParams <em>Params</em>}</li>
 * </ul>
 *
 * @see org.xtext.ocl.ocl.OclPackage#getFeatureCallParameters()
 * @model
 * @generated
 */
public interface FeatureCallParameters extends EObject
{
  /**
   * Returns the value of the '<em><b>Decs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Decs</em>' containment reference.
   * @see #setDecs(Declarator)
   * @see org.xtext.ocl.ocl.OclPackage#getFeatureCallParameters_Decs()
   * @model containment="true"
   * @generated
   */
  Declarator getDecs();

  /**
   * Sets the value of the '{@link org.xtext.ocl.ocl.FeatureCallParameters#getDecs <em>Decs</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Decs</em>' containment reference.
   * @see #getDecs()
   * @generated
   */
  void setDecs(Declarator value);

  /**
   * Returns the value of the '<em><b>Params</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Params</em>' containment reference.
   * @see #setParams(ActualParameterList)
   * @see org.xtext.ocl.ocl.OclPackage#getFeatureCallParameters_Params()
   * @model containment="true"
   * @generated
   */
  ActualParameterList getParams();

  /**
   * Sets the value of the '{@link org.xtext.ocl.ocl.FeatureCallParameters#getParams <em>Params</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Params</em>' containment reference.
   * @see #getParams()
   * @generated
   */
  void setParams(ActualParameterList value);

} // FeatureCallParameters
