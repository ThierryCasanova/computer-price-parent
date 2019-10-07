package tcas.onboarding;

import org.nuxeo.ecm.core.api.DocumentModel;

public interface ComputerPrice {
	
    String PRODUCT_TYPE = "Product";
    String VISUAL_TYPE = "Visual";
    public static final String PRODUCT_SCHEMA = "product_schema";
	public static final String PRODUCT_PRICE = PRODUCT_SCHEMA + ":price";
	
	public static final String PRODUCT_DISTRIBUTOR_NAME_SCH = "product:distributor/name";

	/** Add some methods here. **/
	
	double computePrice(DocumentModel input);
}
