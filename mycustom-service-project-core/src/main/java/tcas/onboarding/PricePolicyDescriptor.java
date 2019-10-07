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
package tcas.onboarding;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.nuxeo.common.xmap.annotation.XNodeMap;
import org.nuxeo.common.xmap.annotation.XObject;

/**
 * @author tcasanova
 *
 */
@XObject("policyByCountry")
public class PricePolicyDescriptor implements Serializable {

	private static final long serialVersionUID = -8970590464705077665L;
	
	//@XNodeMap(value = "increasePrice", key = "@distributor", type = HashMap.class, componentType = Double.class)
    //protected Map<String, Double> pricePolicies = new HashMap<>();

	@XNodeMap(value = "distributors/distributor", key = "@id", type = HashMap.class, componentType = Double.class)
	Map<String, Double> pricePolicies = new HashMap<>();

	
	public Map<String, Double> getPricePolicies() {
		return pricePolicies;
	}

	
}
