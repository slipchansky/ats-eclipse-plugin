/**
 */
package org.agileware.natural.cucumber.cucumber;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.agileware.natural.cucumber.cucumber.Step#getDescription <em>Description</em>}</li>
 *   <li>{@link org.agileware.natural.cucumber.cucumber.Step#getTables <em>Tables</em>}</li>
 *   <li>{@link org.agileware.natural.cucumber.cucumber.Step#getCode <em>Code</em>}</li>
 * </ul>
 *
 * @see org.agileware.natural.cucumber.cucumber.CucumberPackage#getStep()
 * @model
 * @generated
 */
public interface Step extends EObject
{
  /**
   * Returns the value of the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Description</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Description</em>' attribute.
   * @see #setDescription(String)
   * @see org.agileware.natural.cucumber.cucumber.CucumberPackage#getStep_Description()
   * @model
   * @generated
   */
  String getDescription();

  /**
   * Sets the value of the '{@link org.agileware.natural.cucumber.cucumber.Step#getDescription <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Description</em>' attribute.
   * @see #getDescription()
   * @generated
   */
  void setDescription(String value);

  /**
   * Returns the value of the '<em><b>Tables</b></em>' containment reference list.
   * The list contents are of type {@link org.agileware.natural.cucumber.cucumber.Table}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Tables</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tables</em>' containment reference list.
   * @see org.agileware.natural.cucumber.cucumber.CucumberPackage#getStep_Tables()
   * @model containment="true"
   * @generated
   */
  EList<Table> getTables();

  /**
   * Returns the value of the '<em><b>Code</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Code</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Code</em>' containment reference.
   * @see #setCode(DocString)
   * @see org.agileware.natural.cucumber.cucumber.CucumberPackage#getStep_Code()
   * @model containment="true"
   * @generated
   */
  DocString getCode();

  /**
   * Sets the value of the '{@link org.agileware.natural.cucumber.cucumber.Step#getCode <em>Code</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Code</em>' containment reference.
   * @see #getCode()
   * @generated
   */
  void setCode(DocString value);

} // Step
