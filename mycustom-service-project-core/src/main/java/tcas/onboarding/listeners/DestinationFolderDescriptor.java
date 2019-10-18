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
package tcas.onboarding.listeners;

import java.io.Serializable;

import org.nuxeo.common.xmap.annotation.XNode;
import org.nuxeo.common.xmap.annotation.XObject;
import org.nuxeo.runtime.model.Descriptor;

/**
 * @author tcasanova
 *
 */
@XObject("HiddenFolder")
public class DestinationFolderDescriptor implements Descriptor, Serializable{

	private static final long serialVersionUID = -1711856810032076810L;
	
	@XNode("@id")
	String HidenFolderGroupId;
	
	@XNode("parentPath")
	String parentPath;
	
	@XNode("dirName")
	String dirName;

	@Override
	public String getId() {
		return HidenFolderGroupId;
	}
	
	public String getParentPath() {
		return parentPath;
	}

	public String getDirName() {
		return dirName;
	}

}
