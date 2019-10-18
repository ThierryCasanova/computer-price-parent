package tcas.onboarding;

import static tcas.onboarding.ProductEnum.*;
import static com.nuxeo.studio.StudioConstant.*;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.nuxeo.ecm.core.api.CoreSession;
import org.nuxeo.ecm.core.api.DocumentModel;
import org.nuxeo.ecm.core.api.NuxeoException;
import org.nuxeo.runtime.model.ComponentContext;
import org.nuxeo.runtime.model.ComponentInstance;
import org.nuxeo.runtime.model.DefaultComponent;

public class ComputerPriceImpl extends DefaultComponent implements ComputerPrice {
	
	private static final Logger logger = LogManager.getLogger("ComputerPriceImpl");
	
	private Map<String, Double> pricePolicies;
	
    /**
     * Component activated notification.
     * Called when the component is activated. All component dependencies are resolved at that moment.
     * Use this method to initialize the component.
     *
     * @param context the component context.
     */
    @Override
    public void activate(ComponentContext context) {
        super.activate(context);
    }

    /**
     * Component deactivated notification.
     * Called before a component is unregistered.
     * Use this method to do cleanup if any and free any resources held by the component.
     *
     * @param context the component context.
     */
    @Override
    public void deactivate(ComponentContext context) {
        super.deactivate(context);
        pricePolicies = null;
    }

    /**
     * Application started notification.
     * Called after the application started.
     * You can do here any initialization that requires a working application
     * (all resolved bundles and components are active at that moment)
     *
     * @param context the component context. Use it to get the current bundle context
     * @throws Exception
     */
    @Override
    public void applicationStarted(ComponentContext context) {
        // do nothing by default. You can remove this method if not used.
    }

    @Override
    public void registerContribution(Object contribution, String extensionPoint, ComponentInstance contributor) {
        // Add some logic here to handle contributions
    	PricePolicyDescriptor descriptor = (PricePolicyDescriptor) contribution;
    	pricePolicies = descriptor.getPricePolicies();
    }

    @Override
    public void unregisterContribution(Object contribution, String extensionPoint, ComponentInstance contributor) {
        // Logic to do when unregistering any contribution
    }

	@Override
	public double computePrice(DocumentModel input) {
		if (!PRODUCT_DOC_TYPE.equals(input.getType()) && !VISUAL_DOC_TYPE.equals(input.getType()) ){
			throw new NuxeoException("this service works only with " + PRODUCT_DOC_TYPE + " document type.");
		}
		
		String distributorName = (String) input.getPropertyValue(PRODUCT_DISTRIBUTOR_NAME_SCH);
		if (pricePolicies != null || !pricePolicies.isEmpty()) {
			Double increasePrice = pricePolicies.get(distributorName);
			Double price = (Double) input.getPropertyValue(PRODUCT_SCHEMA_PRICE_PROPERTY);
			//add increase to the price
			input.setPropertyValue(PRODUCT_SCHEMA_PRICE_PROPERTY, (price == null ? 0d : price) + increasePrice);
			
			CoreSession coreSession = input.getCoreSession();
			coreSession.saveDocument(input);
			coreSession.save();//pas necessaire dans une operation chain mais conseillé dans un service
		} else {
			logger.error("no extension point defining pricepolicies has been loaded");
		}
		
		Double price = (Double) input.getPropertyValue(PRODUCT_SCHEMA_PRICE_PROPERTY);
		return price == null ? 0 : price.doubleValue();
	}
}
