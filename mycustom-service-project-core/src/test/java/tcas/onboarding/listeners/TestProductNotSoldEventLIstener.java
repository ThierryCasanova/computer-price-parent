package tcas.onboarding.listeners;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nuxeo.ecm.collections.api.CollectionManager;
import org.nuxeo.ecm.core.api.CoreSession;
import org.nuxeo.ecm.core.api.DocumentModel;
import org.nuxeo.ecm.core.event.Event;
import org.nuxeo.ecm.core.event.EventListener;
import org.nuxeo.ecm.core.event.EventProducer;
import org.nuxeo.ecm.core.event.EventService;
import org.nuxeo.ecm.core.event.impl.DocumentEventContext;
import org.nuxeo.ecm.core.event.impl.EventListenerDescriptor;
import org.nuxeo.ecm.core.test.DefaultRepositoryInit;
import org.nuxeo.ecm.core.test.annotations.RepositoryConfig;
import org.nuxeo.runtime.api.Framework;
import org.nuxeo.runtime.test.runner.Features;
import org.nuxeo.runtime.test.runner.FeaturesRunner;

import com.google.inject.Inject;

import tcas.onboarding.TestUtils;
import tcas.onboarding.features.OnBoardingFeatures;

@RunWith(FeaturesRunner.class)
//@Features({ PlatformFeature.class, CollectionFeature.class })
//@Deploy({"tcas.onboarding.computer-price-core"})
//@PartialDeploy(bundle = StudioConstant.BUNDLE_NAME, extensions = {TargetExtensions.Automation.class})
//@PartialDeploy(bundle = StudioConstant.BUNDLE_NAME, extensions = {TargetExtensions.ContentModel.class })
@Features({ OnBoardingFeatures.class })
@RepositoryConfig(init = DefaultRepositoryInit.class)
public class TestProductNotSoldEventLIstener {

	// protected final List<String> events =
	// Arrays.asList("emptyDocumentModelCreated", "aboutToCreate",
	// "documentCreated", "beforeDocumentModification", "documentModified",
	// "aboutToRemove", "documentRemoved", "aboutToCopy", "documentCreatedByCopy",
	// "aboutToMove", "documentMoved", "documentLocked", "documentUnlocked",
	// "aboutToRemoveVersion", "versionRemoved", "aboutToRemoveVersion",
	// "aboutToRemoveVersion", "addcustomevents");

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

		TestUtils.ProductCollectionWrapper productWrapper = TestUtils.createProductWithVisuals(session,
				collectionManager);
		session.save();

		// EventProducer eventProducer = Framework.getService(EventProducer.class);
		EventService eventProducer = Framework.getService(EventService.class);

		DocumentEventContext ctx = new DocumentEventContext(session, session.getPrincipal(),
				productWrapper.getProduct());

		// Hidden Directory
		DocumentModel hiddenVisualDestination = TestUtils.createDoc(session, "/default-domain", "hiddenVisuals",
				"Folder");
		
		Event event = ctx.newEvent("productNotSoldAnymore");
		ctx.setProperty("destination", hiddenVisualDestination);
		
		eventProducer.fireEvent(event);

		EventListenerDescriptor desListener = s.getEventListener("productnotsoldeventlistener");
		assertNotNull(desListener);
		EventListener eLIstener = desListener.asEventListener();
		// test moved Visuals
		for (DocumentModel visual : productWrapper.getVisuals()) {
			
			Assert.assertThat(String.format("the Visual with id %s must be in the hidden folder", visual.getId()),
					session.getDocument(visual.getRef()).getParentRef(), Matchers.equalTo(hiddenVisualDestination.getRef()));
		}

	}
}
