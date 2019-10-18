package tcas.onboarding;

import static com.nuxeo.studio.StudioConstant.PRODUCT_DOC_TYPE;
import static com.nuxeo.studio.StudioConstant.VISUAL_DOC_TYPE;

import java.util.ArrayList;
import java.util.List;

import org.nuxeo.ecm.collections.api.CollectionManager;
import org.nuxeo.ecm.core.api.CoreSession;
import org.nuxeo.ecm.core.api.DocumentModel;

public class TestUtils {

	public static ProductCollection createProductWithVisuals (CoreSession session, CollectionManager collectionManager) {
		
		DocumentModel product = createProduct(session);
		
		List<DocumentModel> visuals = new ArrayList<DocumentModel>();
		for (int i = 0; i < 5; i++) {
			
			visuals.add(createVisual(session));
			
		}
		
		collectionManager.addToCollection(product, visuals, session);
		
		return new ProductCollection(product, visuals);
		
	}
	
	public static DocumentModel createProduct(CoreSession session) {
		
		DocumentModel docProduit = session.createDocumentModel("/default-domain", "my-test-doc", PRODUCT_DOC_TYPE);
    	docProduit = session.createDocument(docProduit);
    	docProduit.setPropertyValue(ProductEnum.PRODUCT_DISTRIBUTOR_NAME_SCH, "France");
    	session.save();
		return docProduit; 
	}
	
	public static DocumentModel createVisual(CoreSession session) {
		//create parent folder
		DocumentModel parent = createDoc(session, "/default-domain", "visuals", "Folder");
		//DocumentModel visual = createDoc(session, parent.getPathAsString(), "aVisual", VISUAL_DOC_TYPE);
		//DocumentModel visual = createDoc(session, "/default-domain/visuals", "aVisual", VISUAL_DOC_TYPE);
		DocumentModel visual = createDoc(session, "/default-domain", "aVisual", VISUAL_DOC_TYPE);
		//TODO sest some properties and save again
		return visual;
	}
	
	public static DocumentModel createDoc (CoreSession session, String parentPath, String name, String typeName) {
		DocumentModel doc =  session.createDocumentModel(parentPath, name, typeName);
		doc = session.createDocument(doc);
		session.saveDocument(doc);
		session.save();
		return doc;
	}
	
	public static class ProductCollection {
		
		private final DocumentModel product;
		private final List<DocumentModel> visuals;
		
		private ProductCollection( DocumentModel product, List<DocumentModel> visuals) {
			this.product = product;
			this.visuals = visuals;
		}

		/**
		 * @return the product
		 */
		public DocumentModel getProduct() {
			return product;
		}

		/**
		 * @return the visuals
		 */
		public List<DocumentModel> getVisuals() {
			return visuals;
		}
	}
}
