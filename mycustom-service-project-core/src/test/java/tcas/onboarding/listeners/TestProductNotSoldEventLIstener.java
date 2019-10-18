package tcas.onboarding.listeners;

import static com.nuxeo.studio.StudioConstant.PRODUCT_DOC_TYPE;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nuxeo.ecm.collections.api.CollectionManager;
import org.nuxeo.ecm.collections.core.test.CollectionFeature;
import org.nuxeo.ecm.core.api.CoreSession;
import org.nuxeo.ecm.core.api.DocumentModel;
import org.nuxeo.ecm.core.event.Event;
import org.nuxeo.ecm.core.event.EventProducer;
import org.nuxeo.ecm.core.event.EventService;
import org.nuxeo.ecm.core.event.impl.DocumentEventContext;
import org.nuxeo.ecm.core.event.impl.EventListenerDescriptor;
import org.nuxeo.ecm.core.test.DefaultRepositoryInit;
import org.nuxeo.ecm.core.test.annotations.RepositoryConfig;
import org.nuxeo.ecm.platform.test.PlatformFeature;
import org.nuxeo.runtime.api.Framework;
import org.nuxeo.runtime.test.runner.Deploy;
import org.nuxeo.runtime.test.runner.Features;
import org.nuxeo.runtime.test.runner.FeaturesRunner;
import org.nuxeo.runtime.test.runner.PartialDeploy;
import org.nuxeo.runtime.test.runner.TargetExtensions;

import com.google.inject.Inject;
import com.nuxeo.studio.StudioConstant;

import tcas.onboarding.TestUtils;
import tcas.onboarding.features.OnBoardingFeatures;

@RunWith(FeaturesRunner.class)
//@Features({ PlatformFeature.class, CollectionFeature.class })
//@Deploy({"tcas.onboarding.computer-price-core"})
//@PartialDeploy(bundle = StudioConstant.BUNDLE_NAME, extensions = {TargetExtensions.Automation.class})
//@PartialDeploy(bundle = StudioConstant.BUNDLE_NAME, extensions = {TargetExtensions.ContentModel.class })
@Features({OnBoardingFeatures.class})
@RepositoryConfig(init = DefaultRepositoryInit.class)
public class TestProductNotSoldEventLIstener {

   // protected final List<String> events = Arrays.asList("emptyDocumentModelCreated", "aboutToCreate", "documentCreated", "beforeDocumentModification", "documentModified", "aboutToRemove", "documentRemoved", "aboutToCopy", "documentCreatedByCopy", "aboutToMove", "documentMoved", "documentLocked", "documentUnlocked", "aboutToRemoveVersion", "versionRemoved", "aboutToRemoveVersion", "aboutToRemoveVersion", "addcustomevents");

    @Inject
    protected EventService s;
    
    @Inject
    protected CoreSession session;
    
    @Inject
    protected CollectionManager collectionManager;

//    @Test
//    public void listenerRegistration() {
//        EventListenerDescriptor listener = s.getEventListener("productnotsoldeventlistener");
//        assertNotNull(listener);
//        assertTrue(events.stream().allMatch(listener::acceptEvent));
//    }
    
    @Test
    public void testEvent() {
    	
    	TestUtils.ProductCollection productCollection = TestUtils.createProductWithVisuals(session, collectionManager);
    	session.save();
    	
    	EventProducer eventProducer = Framework.getService(EventProducer.class);
    	DocumentEventContext ctx = new DocumentEventContext(session, session.getPrincipal(), productCollection.getProduct());
    	
    	//ctx.setProperty("myprop", "something");
    	Event event = ctx.newEvent("productnotsoldeventlistener");
    	eventProducer.fireEvent(event);
    	
    	EventListenerDescriptor listener = s.getEventListener("productnotsoldeventlistener");
        assertNotNull(listener);
    }
}
