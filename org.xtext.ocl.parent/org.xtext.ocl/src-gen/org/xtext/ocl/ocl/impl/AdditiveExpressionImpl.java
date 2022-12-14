/**
 * generated by Xtext 2.26.0-SNAPSHOT
 */
package org.xtext.ocl.ocl.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.xtext.ocl.ocl.AddOperator;
import org.xtext.ocl.ocl.AdditiveExpression;
import org.xtext.ocl.ocl.MultiplicativeExpression;
import org.xtext.ocl.ocl.OclPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Additive Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.ocl.ocl.impl.AdditiveExpressionImpl#getExp <em>Exp</em>}</li>
 *   <li>{@link org.xtext.ocl.ocl.impl.AdditiveExpressionImpl#getOp <em>Op</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AdditiveExpressionImpl extends MinimalEObjectImpl.Container implements AdditiveExpression
{
  /**
   * The cached value of the '{@link #getExp() <em>Exp</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExp()
   * @generated
   * @ordered
   */
  protected EList<MultiplicativeExpression> exp;

  /**
   * The cached value of the '{@link #getOp() <em>Op</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOp()
   * @generated
   * @ordered
   */
  protected EList<AddOperator> op;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AdditiveExpressionImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return OclPackage.Literals.ADDITIVE_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<MultiplicativeExpression> getExp()
  {
    if (exp == null)
    {
      exp = new EObjectContainmentEList<MultiplicativeExpression>(MultiplicativeExpression.class, this, OclPackage.ADDITIVE_EXPRESSION__EXP);
    }
    return exp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<AddOperator> getOp()
  {
    if (op == null)
    {
      op = new EObjectContainmentEList<AddOperator>(AddOperator.class, this, OclPackage.ADDITIVE_EXPRESSION__OP);
    }
    return op;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case OclPackage.ADDITIVE_EXPRESSION__EXP:
        return ((InternalEList<?>)getExp()).basicRemove(otherEnd, msgs);
      case OclPackage.ADDITIVE_EXPRESSION__OP:
        return ((InternalEList<?>)getOp()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case OclPackage.ADDITIVE_EXPRESSION__EXP:
        return getExp();
      case OclPackage.ADDITIVE_EXPRESSION__OP:
        return getOp();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case OclPackage.ADDITIVE_EXPRESSION__EXP:
        getExp().clear();
        getExp().addAll((Collection<? extends MultiplicativeExpression>)newValue);
        return;
      case OclPackage.ADDITIVE_EXPRESSION__OP:
        getOp().clear();
        getOp().addAll((Collection<? extends AddOperator>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case OclPackage.ADDITIVE_EXPRESSION__EXP:
        getExp().clear();
        return;
      case OclPackage.ADDITIVE_EXPRESSION__OP:
        getOp().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case OclPackage.ADDITIVE_EXPRESSION__EXP:
        return exp != null && !exp.isEmpty();
      case OclPackage.ADDITIVE_EXPRESSION__OP:
        return op != null && !op.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //AdditiveExpressionImpl
