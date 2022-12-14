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

import org.xtext.ocl.ocl.AdditiveExpression;
import org.xtext.ocl.ocl.OclPackage;
import org.xtext.ocl.ocl.RelationalExpression;
import org.xtext.ocl.ocl.RelationalOperator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Relational Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.ocl.ocl.impl.RelationalExpressionImpl#getExp <em>Exp</em>}</li>
 *   <li>{@link org.xtext.ocl.ocl.impl.RelationalExpressionImpl#getOp <em>Op</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RelationalExpressionImpl extends MinimalEObjectImpl.Container implements RelationalExpression
{
  /**
   * The cached value of the '{@link #getExp() <em>Exp</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExp()
   * @generated
   * @ordered
   */
  protected EList<AdditiveExpression> exp;

  /**
   * The cached value of the '{@link #getOp() <em>Op</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOp()
   * @generated
   * @ordered
   */
  protected EList<RelationalOperator> op;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RelationalExpressionImpl()
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
    return OclPackage.Literals.RELATIONAL_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<AdditiveExpression> getExp()
  {
    if (exp == null)
    {
      exp = new EObjectContainmentEList<AdditiveExpression>(AdditiveExpression.class, this, OclPackage.RELATIONAL_EXPRESSION__EXP);
    }
    return exp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<RelationalOperator> getOp()
  {
    if (op == null)
    {
      op = new EObjectContainmentEList<RelationalOperator>(RelationalOperator.class, this, OclPackage.RELATIONAL_EXPRESSION__OP);
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
      case OclPackage.RELATIONAL_EXPRESSION__EXP:
        return ((InternalEList<?>)getExp()).basicRemove(otherEnd, msgs);
      case OclPackage.RELATIONAL_EXPRESSION__OP:
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
      case OclPackage.RELATIONAL_EXPRESSION__EXP:
        return getExp();
      case OclPackage.RELATIONAL_EXPRESSION__OP:
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
      case OclPackage.RELATIONAL_EXPRESSION__EXP:
        getExp().clear();
        getExp().addAll((Collection<? extends AdditiveExpression>)newValue);
        return;
      case OclPackage.RELATIONAL_EXPRESSION__OP:
        getOp().clear();
        getOp().addAll((Collection<? extends RelationalOperator>)newValue);
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
      case OclPackage.RELATIONAL_EXPRESSION__EXP:
        getExp().clear();
        return;
      case OclPackage.RELATIONAL_EXPRESSION__OP:
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
      case OclPackage.RELATIONAL_EXPRESSION__EXP:
        return exp != null && !exp.isEmpty();
      case OclPackage.RELATIONAL_EXPRESSION__OP:
        return op != null && !op.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //RelationalExpressionImpl
