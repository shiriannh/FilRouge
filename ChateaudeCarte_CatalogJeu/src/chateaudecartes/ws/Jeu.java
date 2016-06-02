/**
 * Jeu.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package chateaudecartes.ws;

public class Jeu  extends chateaudecartes.ws.AbstractEntity  implements java.io.Serializable {
    private java.lang.String apercu;

    private java.util.Calendar dateSortie;

    private java.lang.String description;

    private chateaudecartes.ws.Editeur editeur;

    private java.lang.String nom;

    private chateaudecartes.ws.Ressource[] rsc;

    public Jeu() {
    }

    public Jeu(
           java.lang.String id,
           java.lang.String apercu,
           java.util.Calendar dateSortie,
           java.lang.String description,
           chateaudecartes.ws.Editeur editeur,
           java.lang.String nom,
           chateaudecartes.ws.Ressource[] rsc) {
        super(
            id);
        this.apercu = apercu;
        this.dateSortie = dateSortie;
        this.description = description;
        this.editeur = editeur;
        this.nom = nom;
        this.rsc = rsc;
    }


    /**
     * Gets the apercu value for this Jeu.
     * 
     * @return apercu
     */
    public java.lang.String getApercu() {
        return apercu;
    }


    /**
     * Sets the apercu value for this Jeu.
     * 
     * @param apercu
     */
    public void setApercu(java.lang.String apercu) {
        this.apercu = apercu;
    }


    /**
     * Gets the dateSortie value for this Jeu.
     * 
     * @return dateSortie
     */
    public java.util.Calendar getDateSortie() {
        return dateSortie;
    }


    /**
     * Sets the dateSortie value for this Jeu.
     * 
     * @param dateSortie
     */
    public void setDateSortie(java.util.Calendar dateSortie) {
        this.dateSortie = dateSortie;
    }


    /**
     * Gets the description value for this Jeu.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this Jeu.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the editeur value for this Jeu.
     * 
     * @return editeur
     */
    public chateaudecartes.ws.Editeur getEditeur() {
        return editeur;
    }


    /**
     * Sets the editeur value for this Jeu.
     * 
     * @param editeur
     */
    public void setEditeur(chateaudecartes.ws.Editeur editeur) {
        this.editeur = editeur;
    }


    /**
     * Gets the nom value for this Jeu.
     * 
     * @return nom
     */
    public java.lang.String getNom() {
        return nom;
    }


    /**
     * Sets the nom value for this Jeu.
     * 
     * @param nom
     */
    public void setNom(java.lang.String nom) {
        this.nom = nom;
    }


    /**
     * Gets the rsc value for this Jeu.
     * 
     * @return rsc
     */
    public chateaudecartes.ws.Ressource[] getRsc() {
        return rsc;
    }


    /**
     * Sets the rsc value for this Jeu.
     * 
     * @param rsc
     */
    public void setRsc(chateaudecartes.ws.Ressource[] rsc) {
        this.rsc = rsc;
    }

    public chateaudecartes.ws.Ressource getRsc(int i) {
        return this.rsc[i];
    }

    public void setRsc(int i, chateaudecartes.ws.Ressource _value) {
        this.rsc[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Jeu)) return false;
        Jeu other = (Jeu) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.apercu==null && other.getApercu()==null) || 
             (this.apercu!=null &&
              this.apercu.equals(other.getApercu()))) &&
            ((this.dateSortie==null && other.getDateSortie()==null) || 
             (this.dateSortie!=null &&
              this.dateSortie.equals(other.getDateSortie()))) &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.editeur==null && other.getEditeur()==null) || 
             (this.editeur!=null &&
              this.editeur.equals(other.getEditeur()))) &&
            ((this.nom==null && other.getNom()==null) || 
             (this.nom!=null &&
              this.nom.equals(other.getNom()))) &&
            ((this.rsc==null && other.getRsc()==null) || 
             (this.rsc!=null &&
              java.util.Arrays.equals(this.rsc, other.getRsc())));
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
        if (getApercu() != null) {
            _hashCode += getApercu().hashCode();
        }
        if (getDateSortie() != null) {
            _hashCode += getDateSortie().hashCode();
        }
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getEditeur() != null) {
            _hashCode += getEditeur().hashCode();
        }
        if (getNom() != null) {
            _hashCode += getNom().hashCode();
        }
        if (getRsc() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRsc());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRsc(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Jeu.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.chateaudecartes/", "jeu"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("apercu");
        elemField.setXmlName(new javax.xml.namespace.QName("", "apercu"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dateSortie");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dateSortie"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("description");
        elemField.setXmlName(new javax.xml.namespace.QName("", "description"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("editeur");
        elemField.setXmlName(new javax.xml.namespace.QName("", "editeur"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.chateaudecartes/", "editeur"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rsc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "rsc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.chateaudecartes/", "ressource"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
