//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2017.07.31 alle 01:30:37 PM CEST 
//


package model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the model package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Prodotti_QNAME = new QName("", "prodotti");
    private final static QName _Prodotto_QNAME = new QName("", "prodotto");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: model
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Prodotti }
     * 
     */
    public Prodotti createProdotti() {
        return new Prodotti();
    }

    /**
     * Create an instance of {@link Prodotto }
     * 
     */
    public Prodotto createProdotto() {
        return new Prodotto();
    }

    /**
     * Create an instance of {@link Categoria }
     * 
     */
    public Categoria createCategoria() {
        return new Categoria();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Prodotti }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "prodotti")
    public JAXBElement<Prodotti> createProdotti(Prodotti value) {
        return new JAXBElement<Prodotti>(_Prodotti_QNAME, Prodotti.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Prodotto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "prodotto")
    public JAXBElement<Prodotto> createProdotto(Prodotto value) {
        return new JAXBElement<Prodotto>(_Prodotto_QNAME, Prodotto.class, null, value);
    }

}
