package tcas.onboarding.listeners;


import static com.nuxeo.studio.StudioConstant.PRODUCT_DOC_TYPE;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.nuxeo.ecm.collections.core.adapter.Collection;
import org.nuxeo.ecm.core.api.CoreSession;
import org.nuxeo.ecm.core.api.DocumentModel;
import org.nuxeo.ecm.core.api.DocumentRef;
import org.nuxeo.ecm.core.api.IdRef;

import org.nuxeo.ecm.core.event.Event;
import org.nuxeo.ecm.core.event.EventContext;
import org.nuxeo.ecm.core.event.EventListener;
import org.nuxeo.ecm.core.event.impl.DocumentEventContext;

//public class ProductNotSoldEventLIstener extends DefaultComponent implements EventListener {
public class ProductNotSoldEventLIstener implements EventListener {
  
	private static final Logger LOGGER = LogManager.getLogger(ProductNotSoldEventLIstener.class);

    @Override
    public void handleEvent(Event event) {
    	
    	LOGGER.debug("new Event not sold anymore handled {}" , event);
        EventContext ctx = event.getContext();
        if (!(ctx instanceof DocumentEventContext)) {
          return;
        }

        DocumentEventContext docCtx = (DocumentEventContext) ctx;
        DocumentModel doc = docCtx.getSourceDocument();
        
        // Add some logic starting from here.
       if (doc != null && PRODUCT_DOC_TYPE.equals(doc.getType())) {
    	   process(ctx, doc);
       } else {
    	   LOGGER.warn("Document {} not handled by this listener", doc);
       }
        
    }

	protected void process(EventContext ctx, DocumentModel product) {
		LOGGER.debug("process document : {} " , product);
		CoreSession session = product.getCoreSession();
		
		//TODO retrieve HiddenFolder path
		//List<Descriptor> descriptors =  getDescriptors("destinationFolder");
		//LOGGER.info("descripteurs = {} ",descriptors);
		//coreSession.getOrCreateDocument(docModel)
		
		//Retrieve all Product's Visuals to move them
		Collection collectionAdapter = product.getAdapter(Collection.class);
		List<String> visualIds = collectionAdapter.getCollectedDocumentIds();
		
		if (CollectionUtils.isNotEmpty(visualIds)) {
			LOGGER.debug("moving visuals {} to hiden folder {}", visualIds, "todefine");
			List<DocumentRef> visualRefs = visualIds.stream().map(IdRef::new).collect(Collectors.toList());
			
			//TODO session.move(visualRefs, dst);
		}
		
		
	}


}
