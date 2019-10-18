package tcas.onboarding;

import static com.nuxeo.studio.StudioConstant.PRODUCT_DOC_TYPE;
import static com.nuxeo.studio.StudioConstant.PRODUCT_SCHEMA_PRICE_PROPERTY;
import static com.nuxeo.studio.StudioConstant.VISUAL_DOC_TYPE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nuxeo.ecm.automation.test.AutomationFeature;
import org.nuxeo.ecm.core.api.CoreSession;
import org.nuxeo.ecm.core.api.DocumentModel;
import org.nuxeo.ecm.core.test.CoreFeature;
import org.nuxeo.runtime.test.runner.Deploy;
import org.nuxeo.runtime.test.runner.Features;
import org.nuxeo.runtime.test.runner.FeaturesRunner;
import org.nuxeo.runtime.test.runner.PartialDeploy;
import org.nuxeo.runtime.test.runner.TargetExtensions;
import org.nuxeo.runtime.test.runner.TransactionalFeature;

import com.nuxeo.studio.StudioConstant;

//import com.google.inject.Inject;
//import com.mysql.cj.CoreSession;

@RunWith(FeaturesRunner.class)
//@Features({ PlatformFeature.class })
@Features({ AutomationFeature.class })
@Deploy("tcas.onboarding.computer-price-core")
//@Deploy("org.nuxeo.ecm.platform.picture.core")
//@Deploy({"tcas.onboarding.computer-price-core", StudioConstant.BUNDLE_NAME})
//@Deploy("org.nuxeo.rutime:OSGI-INF/priceupdater-pricepolicy-conrib.xml")
//@PartialDeploy(bundle = StudioConstant.BUNDLE_NAME, extensions = {TargetExtensions.Automation.class})
@PartialDeploy(bundle = StudioConstant.BUNDLE_NAME, extensions = {TargetExtensions.ContentModel.class})
//@Deploy(StudioConstant.BUNDLE_NAME)
//@RepositoryConfig(init = DefaultRepositoryInit.class) 
public class TestComputerPrice {

    @Inject
    protected ComputerPrice computerprice;
    
    @Inject CoreSession session;
    
    @Inject CoreFeature coreFeature;
    
    @Inject TransactionalFeature transactionalFeature;

    @Test
    public void testService() {
        assertNotNull(computerprice);
        
    }
    
    @Test
    public void testComputePrice() {
    	//DocumentModel docProduit = session.createDocumentModel(ComputerPrice.PRODUCT_TYPE);
    	DocumentModel docProduit = session.createDocumentModel("/default-domain", "my-test-doc", PRODUCT_DOC_TYPE);
    	docProduit = session.createDocument(docProduit);
    	docProduit.setPropertyValue(ProductEnum.PRODUCT_DISTRIBUTOR_NAME_SCH, "France");
    	//docProduit.setPropertyValue(ComputerPrice.PRODUCT_DISTRIBUTOR_NAME_SCH, "EN");
    	//docProduit.setPropertyValue(ComputerPrice.PRODUCT_PRICE, 5d);
    	
    	double resultPrice = computerprice.computePrice(docProduit);
    	transactionalFeature.nextTransaction();
    	
    	DocumentModel document = session.getDocument(docProduit.getRef());
    	//double propertyValue = (double) document.getPropertyValue(ComputerPrice.PRODUCT_PRICE);
    	Double propertyValue = (Double) document.getPropertyValue(PRODUCT_SCHEMA_PRICE_PROPERTY);
    	
		assertEquals(5.0d ,(propertyValue!=null? propertyValue.doubleValue():0.d), 0);
    }
    
    @Test
    public void testCreateVisual() {
    	DocumentModel doc = session.createDocumentModel(VISUAL_DOC_TYPE);
    	//DocumentModel doc = session.createDocumentModel(PRODUCT_DOC_TYPE);
    	doc = session.createDocument(doc);
    	session.saveDocument(doc);
    	session.save();
    }
}