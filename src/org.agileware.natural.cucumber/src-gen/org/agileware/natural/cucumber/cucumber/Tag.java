/**
 */
package org.agileware.natural.cucumber.cucumber;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tag</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.agileware.natural.cucumber.cucumber.Tag#getId <em>Id</em>}</li>
 * </ul>
 *
 * @see org.agileware.natural.cucumber.cucumber.CucumberPackage#getTag()
 * @model
 * @generated
 */
public interface Tag extends EObject
{
  /**
   * Returns the value of the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Id</em>' attribute.
   * @see #setId(String)
   * @see org.agileware.natural.cucumber.cucumber.CucumberPackage#getTag_Id()
   * @model
   * @generated
   */
  String getId();

  /**
   * Sets the value of the '{@link org.agileware.natural.cucumber.cucumber.Tag#getId <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Id</em>' attribute.
   * @see #getId()
   * @generated
   */
  void setId(String value);

} // Tag
