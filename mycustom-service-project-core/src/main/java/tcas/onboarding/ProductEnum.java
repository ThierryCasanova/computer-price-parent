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

import static com.nuxeo.studio.StudioConstant.*;

/**
 * @author tcasanova
 *
 */
public enum ProductEnum {
	
	
	DESCRIPTION("dc:description"),
	//DISTRIBUTOR("product:distributor"),
	
	TITLE("dc:title");
	
	public static final String PRODUCT_DISTRIBUTOR_NAME_SCH = PRODUCT_SCHEMA_DISTRIBUTOR_PROPERTY +"/name";

	
	ProductEnum(String xPath){
		this.xPath = xPath;
	}
	
	private final String xPath;

	public String getxPath() {
		return xPath;
	}
}
