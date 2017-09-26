/**
 */
package org.agileware.natural.cucumber.cucumber;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Background</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.agileware.natural.cucumber.cucumber.Background#getTitle <em>Title</em>}</li>
 *   <li>{@link org.agileware.natural.cucumber.cucumber.Background#getNarrative <em>Narrative</em>}</li>
 *   <li>{@link org.agileware.natural.cucumber.cucumber.Background#getSteps <em>Steps</em>}</li>
 * </ul>
 *
 * @see org.agileware.natural.cucumber.cucumber.CucumberPackage#getBackground()
 * @model
 * @generated
 */
public interface Background extends EObject
{
  /**
   * Returns the value of the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Title</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Title</em>' attribute.
   * @see #setTitle(String)
   * @see org.agileware.natural.cucumber.cucumber.CucumberPackage#getBackground_Title()
   * @model
   * @generated
   */
  String getTitle();

  /**
   * Sets the value of the '{@link org.agileware.natural.cucumber.cucumber.Background#getTitle <em>Title</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Title</em>' attribute.
   * @see #getTitle()
   * @generated
   */
  void setTitle(String value);

  /**
   * Returns the value of the '<em><b>Narrative</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Narrative</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Narrative</em>' attribute.
   * @see #setNarrative(String)
   * @see org.agileware.natural.cucumber.cucumber.CucumberPackage#getBackground_Narrative()
   * @model
   * @generated
   */
  String getNarrative();

  /**
   * Sets the value of the '{@link org.agileware.natural.cucumber.cucumber.Background#getNarrative <em>Narrative</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Narrative</em>' attribute.
   * @see #getNarrative()
   * @generated
   */
  void setNarrative(String value);

  /**
   * Returns the value of the '<em><b>Steps</b></em>' containment reference list.
   * The list contents are of type {@link org.agileware.natural.cucumber.cucumber.Step}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Steps</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Steps</em>' containment reference list.
   * @see org.agileware.natural.cucumber.cucumber.CucumberPackage#getBackground_Steps()
   * @model containment="true"
   * @generated
   */
  EList<Step> getSteps();

} // Background
