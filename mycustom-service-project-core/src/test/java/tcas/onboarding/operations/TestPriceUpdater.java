package tcas.onboarding.operations;

import static org.junit.Assert.assertTrue;
import static tcas.onboarding.ProductEnum.*;
import static com.nuxeo.studio.StudioConstant.*;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nuxeo.ecm.automation.AutomationService;
import org.nuxeo.ecm.automation.OperationContext;
import org.nuxeo.ecm.automation.OperationException;
import org.nuxeo.ecm.automation.test.AutomationFeature;
import org.nuxeo.ecm.core.api.CoreSession;
import org.nuxeo.ecm.core.api.DocumentModel;
import org.nuxeo.ecm.core.test.DefaultRepositoryInit;
import org.nuxeo.ecm.core.test.annotations.Granularity;
import org.nuxeo.ecm.core.test.annotations.RepositoryConfig;
import org.nuxeo.runtime.test.runner.Deploy;
import org.nuxeo.runtime.test.runner.Features;
import org.nuxeo.runtime.test.runner.FeaturesRunner;
import org.nuxeo.runtime.test.runner.PartialDeploy;
import org.nuxeo.runtime.test.runner.TargetExtensions;

import com.nuxeo.studio.StudioConstant;

import tcas.onboarding.ProductEnum;

@RunWith(FeaturesRunner.class)
@Features(AutomationFeature.class)
@RepositoryConfig(init = DefaultRepositoryInit.class, cleanup = Granularity.METHOD)
@Deploy("tcas.onboarding.computer-price-core")
@PartialDeploy(bundle = StudioConstant.BUNDLE_NAME, extensions = {TargetExtensions.Automation.class})
public class TestPriceUpdater {

	private static final Logger logger = LogManager.getLogger("TestPriceUpdater");
    @Inject
    protected CoreSession session;

    @Inject
    protected AutomationService automationService;

    @Test
    public void shouldCallTheOperation() throws OperationException {
    	
    	DocumentModel docProduit = session.createDocumentModel(PRODUCT_DOC_TYPE);
    	docProduit = session.createDocument(docProduit);
    	docProduit.setPropertyValue(ProductEnum.PRODUCT_DISTRIBUTOR_NAME_SCH, "France");
    	session.save();
    	
        OperationContext ctx = new OperationContext(session);
        
        ctx.setInput(docProduit);
        
        DocumentModel doc = (DocumentModel) automationService.run(ctx, PriceUpdater.ID);
        double price = (double) doc.getPropertyValue(PRODUCT_SCHEMA_PRICE_PROPERTY);
        logger.info("product price = {}", doc.getPropertyValue(PRODUCT_SCHEMA_PRICE_PROPERTY));
        logger.warn("path string = {} ",doc.getPathAsString());
        
        assertTrue("product should have a price ", price >0);
        //assertEquals("/", doc.getPathAsString());
    }

    @Test
    public void shouldCallWithParameters() throws OperationException {
    	
        final String path = "/default-domain";
        OperationContext ctx = new OperationContext(session);
        
        DocumentModel docProduit = session.createDocumentModel(PRODUCT_DOC_TYPE);
        docProduit = session.createDocument(docProduit);
        docProduit.setPropertyValue(ProductEnum.PRODUCT_DISTRIBUTOR_NAME_SCH, "France");
        ctx.setInput(docProduit);
        
        Map<String, Object> params = new HashMap<>();
        params.put("path", path);
        DocumentModel doc = (DocumentModel) automationService.run(ctx, PriceUpdater.ID, params);
        logger.warn("path string = {} ",doc.getPathAsString());
        //assertEquals(path, doc.getPathAsString());
    }
}
