package tcas.onboarding.documents;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nuxeo.ecm.core.api.CoreSession;
import org.nuxeo.ecm.core.api.DocumentModel;
import org.nuxeo.ecm.core.test.CoreFeature;
import org.nuxeo.runtime.test.runner.Deploy;
import org.nuxeo.runtime.test.runner.Features;
import org.nuxeo.runtime.test.runner.FeaturesRunner;
import org.nuxeo.runtime.test.runner.PartialDeploy;
import org.nuxeo.runtime.test.runner.TargetExtensions;

import com.nuxeo.studio.StudioConstant;

import tcas.onboarding.documents.ProductAdapter;

@RunWith(FeaturesRunner.class)
@Features(CoreFeature.class)
@Deploy({"tcas.onboarding.computer-price-core"})
@PartialDeploy(bundle = StudioConstant.BUNDLE_NAME, extensions = {TargetExtensions.Automation.class})
public class TestProductAdapter {
  @Inject
  CoreSession session;

  @Test
  public void shouldCallTheAdapter() {
    String doctype = "Product";
    String testTitle = "My Adapter Title";

    DocumentModel doc = session.createDocumentModel("/", "test-adapter", doctype);
    ProductAdapter adapter = doc.getAdapter(ProductAdapter.class);
    adapter.setTitle(testTitle);
    Assert.assertEquals("Document title does not match when using the adapter", testTitle, adapter.getTitle());
  }
  
  @Test
  public void testComplexType() {
	  String doctype = "Product";
	  String sellLocation = "New_York";
	  
	  DocumentModel doc = session.createDocumentModel("/", "test-adapter", doctype);
	  ProductAdapter adapter = doc.getAdapter(ProductAdapter.class);
	  	  
	  adapter.setDistributor("US", sellLocation);
	  
	  Assert.assertEquals("wrong sell location", sellLocation, adapter.getSellLocation());
  }
}
