/**
 * generated by Xtext 2.26.0-SNAPSHOT
 */
package org.xtext.ocl.ocl.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.xtext.ocl.ocl.EnumerationType;
import org.xtext.ocl.ocl.Name;
import org.xtext.ocl.ocl.OclPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enumeration Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.ocl.ocl.impl.EnumerationTypeImpl#getLeft <em>Left</em>}</li>
 *   <li>{@link org.xtext.ocl.ocl.impl.EnumerationTypeImpl#getRights <em>Rights</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EnumerationTypeImpl extends SimpleTypeSpecifierImpl implements EnumerationType
{
  /**
   * The cached value of the '{@link #getLeft() <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLeft()
   * @generated
   * @ordered
   */
  protected Name left;

  /**
   * The cached value of the '{@link #getRights() <em>Rights</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRights()
   * @generated
   * @ordered
   */
  protected EList<Name> rights;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EnumerationTypeImpl()
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
    return OclPackage.Literals.ENUMERATION_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Name getLeft()
  {
    return left;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLeft(Name newLeft, NotificationChain msgs)
  {
    Name oldLeft = left;
    left = newLeft;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OclPackage.ENUMERATION_TYPE__LEFT, oldLeft, newLeft);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setLeft(Name newLeft)
  {
    if (newLeft != left)
    {
      NotificationChain msgs = null;
      if (left != null)
        msgs = ((InternalEObject)left).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OclPackage.ENUMERATION_TYPE__LEFT, null, msgs);
      if (newLeft != null)
        msgs = ((InternalEObject)newLeft).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OclPackage.ENUMERATION_TYPE__LEFT, null, msgs);
      msgs = basicSetLeft(newLeft, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OclPackage.ENUMERATION_TYPE__LEFT, newLeft, newLeft));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Name> getRights()
  {
    if (rights == null)
    {
      rights = new EObjectContainmentEList<Name>(Name.class, this, OclPackage.ENUMERATION_TYPE__RIGHTS);
    }
    return rights;
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
      case OclPackage.ENUMERATION_TYPE__LEFT:
        return basicSetLeft(null, msgs);
      case OclPackage.ENUMERATION_TYPE__RIGHTS:
        return ((InternalEList<?>)getRights()).basicRemove(otherEnd, msgs);
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
      case OclPackage.ENUMERATION_TYPE__LEFT:
        return getLeft();
      case OclPackage.ENUMERATION_TYPE__RIGHTS:
        return getRights();
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
      case OclPackage.ENUMERATION_TYPE__LEFT:
        setLeft((Name)newValue);
        return;
      case OclPackage.ENUMERATION_TYPE__RIGHTS:
        getRights().clear();
        getRights().addAll((Collection<? extends Name>)newValue);
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
      case OclPackage.ENUMERATION_TYPE__LEFT:
        setLeft((Name)null);
        return;
      case OclPackage.ENUMERATION_TYPE__RIGHTS:
        getRights().clear();
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
      case OclPackage.ENUMERATION_TYPE__LEFT:
        return left != null;
      case OclPackage.ENUMERATION_TYPE__RIGHTS:
        return rights != null && !rights.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //EnumerationTypeImpl
