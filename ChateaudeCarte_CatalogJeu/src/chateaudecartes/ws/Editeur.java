/**
 * Editeur.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package chateaudecartes.ws;

public class Editeur  extends chateaudecartes.ws.AbstractEntity  implements java.io.Serializable {
    private chateaudecartes.ws.Jeu[] jeux;

    private java.lang.String logo;

    private java.lang.String nom;

    public Editeur() {
    }

    public Editeur(
           java.lang.String id,
           chateaudecartes.ws.Jeu[] jeux,
           java.lang.String logo,
           java.lang.String nom) {
        super(
            id);
        this.jeux = jeux;
        this.logo = logo;
        this.nom = nom;
    }


    /**
     * Gets the jeux value for this Editeur.
     * 
     * @return jeux
     */
    public chateaudecartes.ws.Jeu[] getJeux() {
        return jeux;
    }


    /**
     * Sets the jeux value for this Editeur.
     * 
     * @param jeux
     */
    public void setJeux(chateaudecartes.ws.Jeu[] jeux) {
        this.jeux = jeux;
    }

    public chateaudecartes.ws.Jeu getJeux(int i) {
        return this.jeux[i];
    }

    public void setJeux(int i, chateaudecartes.ws.Jeu _value) {
        this.jeux[i] = _value;
    }


    /**
     * Gets the logo value for this Editeur.
     * 
     * @return logo
     */
    public java.lang.String getLogo() {
        return logo;
    }


    /**
     * Sets the logo value for this Editeur.
     * 
     * @param logo
     */
    public void setLogo(java.lang.String logo) {
        this.logo = logo;
    }


    /**
     * Gets the nom value for this Editeur.
     * 
     * @return nom
     */
    public java.lang.String getNom() {
        return nom;
    }


    /**
     * Sets the nom value for this Editeur.
     * 
     * @param nom
     */
    public void setNom(java.lang.String nom) {
        this.nom = nom;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Editeur)) return false;
        Editeur other = (Editeur) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.jeux==null && other.getJeux()==null) || 
             (this.jeux!=null &&
              java.util.Arrays.equals(this.jeux, other.getJeux()))) &&
            ((this.logo==null && other.getLogo()==null) || 
             (this.logo!=null &&
              this.logo.equals(other.getLogo()))) &&
            ((this.nom==null && other.getNom()==null) || 
             (this.nom!=null &&
              this.nom.equals(other.getNom())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getJeux() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getJeux());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getJeux(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getLogo() != null) {
            _hashCode += getLogo().hashCode();
        }
        if (getNom() != null) {
            _hashCode += getNom().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Editeur.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.chateaudecartes/", "editeur"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("jeux");
        elemField.setXmlName(new javax.xml.namespace.QName("", "jeux"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.chateaudecartes/", "jeu"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("logo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "logo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nom");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nom"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
