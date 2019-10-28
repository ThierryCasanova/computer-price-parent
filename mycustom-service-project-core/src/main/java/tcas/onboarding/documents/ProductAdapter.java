package tcas.onboarding.documents;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.nuxeo.ecm.core.api.CoreSession;
import org.nuxeo.ecm.core.api.DocumentModel;
import org.nuxeo.ecm.core.api.DocumentRef;
import org.nuxeo.ecm.core.api.model.Property;

import static com.nuxeo.studio.StudioConstant.*;
import static tcas.onboarding.ProductEnum.*;

/**
 *
 */
public class ProductAdapter {
  protected DocumentModel doc;

  protected String titleXpath = "dc:title";
  protected String descriptionXpath = "dc:description";
  
  protected String distributorXpath = "product:distributor";

  public ProductAdapter(DocumentModel doc) {
    this.doc = doc;
  }

  // Basic methods
  //
  // Note that we voluntarily expose only a subset of the DocumentModel API in this adapter.
  // You may wish to complete it without exposing everything!
  // For instance to avoid letting people change the document state using your adapter,
  // because this would be handled through workflows / buttons / events in your application.
  //

  public void save() {
    CoreSession session = doc.getCoreSession();
    doc = session.saveDocument(doc);
  }

  public DocumentRef getParentRef() {
    return doc.getParentRef();
  }

  // Technical properties retrieval
  public String getId() {
    return doc.getId();
  }

  public String getName() {
    return doc.getName();
  }

  public String getPath() {
    return doc.getPathAsString();
  }

  public String getState() {
    return doc.getCurrentLifeCycleState();
  }

  // Metadata get / set
  public String getTitle() {
    return doc.getTitle();
  }

  public void setTitle(String value) {
    doc.setPropertyValue(TITLE.getxPath(), value);
  }

  public String getDescription() {
    return (String) doc.getPropertyValue(DESCRIPTION.getxPath());
  }

  public void setDescription(String value) {
    doc.setPropertyValue(DESCRIPTION.getxPath(), value);
  }
  
  public void setDistributor(String name, String sellLocation) {
	  Map<String, Serializable> distributor = new HashMap<>();
	  distributor.put("name", name);
	  distributor.put("sell_location", sellLocation);
	  doc.setPropertyValue(PRODUCT_SCHEMA_DISTRIBUTOR_PROPERTY, (Serializable) distributor);
  }
  
  public String getDistributorName() {
	  Property distributor = doc.getProperty(PRODUCT_SCHEMA_DISTRIBUTOR_PROPERTY);
	  return (distributor!= null ? distributor.getValue(String.class, "name") : null);
  }
  
  public String getSellLocation() {
	  Property distributor = doc.getProperty(PRODUCT_SCHEMA_DISTRIBUTOR_PROPERTY);
	  return (distributor!= null ? distributor.getValue(String.class, "sell_location") : null);
  }
  
}
