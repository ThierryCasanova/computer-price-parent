package tcas.onboarding.operations;

import javax.inject.Inject;

import org.nuxeo.ecm.automation.core.Constants;
import org.nuxeo.ecm.automation.core.annotations.Context;
import org.nuxeo.ecm.automation.core.annotations.Operation;
import org.nuxeo.ecm.automation.core.annotations.OperationMethod;
import org.nuxeo.ecm.automation.core.annotations.Param;
import org.nuxeo.ecm.automation.core.collectors.DocumentModelCollector;
import org.nuxeo.ecm.core.api.CoreSession;
import org.nuxeo.ecm.core.api.DocumentModel;
import org.nuxeo.runtime.api.Framework;

import tcas.onboarding.ComputerPrice;

/**
 *
 */
@Operation(id=PriceUpdater.ID, category=Constants.CAT_DOCUMENT, label="Price Updater", description="Update price for each documents in the list")
public class PriceUpdater {

    public static final String ID = "Document.PriceUpdater";

    @Context
    protected CoreSession session;
    
    @Context
    protected ComputerPrice computerprice;
    
    
      
    @Param(name = "path", required = false)
    protected String path;

    @OperationMethod(collector = DocumentModelCollector.class)
    public DocumentModel run(DocumentModel input) {
    	
    	//ComputerPrice computerprice = Framework.getService(ComputerPrice.class);
    	
    	computerprice.computePrice(input);
    	
        return input;
    }
}
