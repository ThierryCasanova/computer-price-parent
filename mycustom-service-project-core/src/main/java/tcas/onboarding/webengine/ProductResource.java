/*
 * (C) Copyright 2006-2007 Nuxeo SA (http://nuxeo.com/) and others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 *     Nuxeo - initial API and implementation
 *
 * 
 */
/**
 * 
 */
package tcas.onboarding.webengine;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.nuxeo.ecm.core.api.CoreSession;
import org.nuxeo.ecm.core.api.DocumentModel;
import org.nuxeo.ecm.core.api.IdRef;
import org.nuxeo.ecm.webengine.model.WebObject;
import org.nuxeo.ecm.webengine.model.impl.ModuleRoot;
import org.nuxeo.runtime.api.Framework;

import tcas.onboarding.ComputerPrice;

/**
 * @author tcasanova
 *
 */
@WebObject(type = "product")
@Path("/product")
public class ProductResource extends ModuleRoot {

	 
	protected ComputerPrice service4ProductPrice;
	
	/**
	 * Construct a new ProductResource instance
	 */
	public ProductResource() {
		super();
		service4ProductPrice = Framework.getService(ComputerPrice.class);
	}

	 @GET
	  public String doGet() {
	    return "test: Hello World!";
	  }
	 
	 @GET
	  @Path("{id}/price")
	  public Object getUPdtatedPrice(@PathParam("id") String productId) {
		 
		 CoreSession session = getContext().getCoreSession();
		 DocumentModel product = session.getDocument(new IdRef(productId));
		 
		 double price = service4ProductPrice.computePrice(product);
	
	   // return "Sample1: Hello "+price+"!";
	    return getTemplate("product.ftl").arg("productId", productId).arg("price", price);
	  }
}
